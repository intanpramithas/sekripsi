package calories.com.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import calories.com.Adapter.FoodDetailListAdapter;
import calories.com.Adapter.FoodItemListAdapter;
import calories.com.Adapter.FoodItemSearchAdapter;
import calories.com.DataSource.FoodItemDataSource;
import calories.com.Model.FoodItem;
import calories.com.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class KonsumsiKaloriFragment extends Fragment implements View.OnClickListener {

    private ArrayList<FoodItem> TampMakanan = new ArrayList<>();

    private FoodItemSearchAdapter foodItemSearchAdapter;
    private FoodDetailListAdapter foodDetailListAdapter;
    private FoodItemListAdapter adapterFoodCategoryList;

    private BottomSheetBehavior bsbFoodSearch;
    private BottomSheetBehavior bsbFoodDetail;
    private LinearLayout llFoodSearchContainer;
    private LinearLayout llFoodDetailContainer;
    private ImageView ivAddBreakfast;
    private ImageView ivAddLunch;
    private ImageView ivAddDinner;
    private ImageView ivAddSnack;
    private MaterialButton mbtn_detail_breakfast;
    private MaterialButton mbtn_detail_lunch;
    private MaterialButton mbtn_detail_dinner;
    private MaterialButton mbtn_detail_snack;
    private MaterialButton mbtn_reset;
    private RecyclerView rvFoodListSearch;
    private RecyclerView rvFoodDetail;
    private ArrayList<FoodItem> objFood;
    private FoodItemDataSource dataSource;
    private TextView tv_kebutuhan_kalori_tubuh;
    private TextView tv_batas_kalori_makan;
    private TextView tv_food_description;
    private TextView tv_food_calory;
    private TextView tv_date;
    private Double strtext;
    private Double strtextkalorimakanan;
    private double jumlahkalorimakanan;
    private int jumlahmakanan;
    private float TampKaloriMakan;
    private float TampKaloriMakanBaru;
    private float TampPorsiMakanan;
    private int categoryId;
    private boolean isShowingFoodItem;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private String dateSP;
    private String dateNow;
    private String kategori;



    public KonsumsiKaloriFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_konsumsi_kalori, container, false);

        initView(root);
        setOnBackPressedCallback();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        setFoodItemSearchRecyclerView();
//        setFoodDetailRecyclerView();

    }


    public void initView(final View rootView) {


        tv_food_description = rootView.findViewById(R.id.tv_food_description);
        tv_food_calory = rootView.findViewById(R.id.tv_food_calory);
        tv_kebutuhan_kalori_tubuh = rootView.findViewById(R.id.tv_kebutuhan_kalori_tubuh);
        tv_batas_kalori_makan = rootView.findViewById(R.id.tv_batas_kalori_makan);
        llFoodSearchContainer = rootView.findViewById(R.id.ll_bottomsheet_container);
        llFoodDetailContainer = rootView.findViewById(R.id.ll_bottomsheet_container_detail);
        ivAddBreakfast = rootView.findViewById(R.id.iv_add_breakfast);
        ivAddLunch = rootView.findViewById(R.id.iv_add_lunch);
        ivAddDinner = rootView.findViewById(R.id.iv_add_dinner);
        ivAddSnack = rootView.findViewById(R.id.iv_add_snack);
        mbtn_detail_breakfast = rootView.findViewById(R.id.mbtn_detail_breakfast);
        mbtn_detail_lunch = rootView.findViewById(R.id.mbtn_detail_lunch);
        mbtn_detail_dinner = rootView.findViewById(R.id.mbtn_detail_dinner);
        mbtn_detail_snack = rootView.findViewById(R.id.mbtn_detail_snack);
        mbtn_reset = rootView.findViewById(R.id.mbtn_reset);
        rvFoodListSearch = rootView.findViewById(R.id.rv_food_list_search);
        rvFoodDetail = rootView.findViewById(R.id.rv_food_detail);
        mSwipeRefreshLayout = rootView.findViewById(R.id.swiperefresh);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initView(rootView);
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });



        bsbFoodSearch = BottomSheetBehavior.from(llFoodSearchContainer);
        bsbFoodDetail = BottomSheetBehavior.from(llFoodDetailContainer);

        ivAddBreakfast.setOnClickListener(this);
        ivAddLunch.setOnClickListener(this);
        ivAddDinner.setOnClickListener(this);
        ivAddSnack.setOnClickListener(this);

        mbtn_detail_breakfast.setOnClickListener(this);
        mbtn_detail_lunch.setOnClickListener(this);
        mbtn_detail_dinner.setOnClickListener(this);
        mbtn_detail_snack.setOnClickListener(this);
        mbtn_reset.setOnClickListener(this);


        //tanggal sekarang
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        tv_date = rootView.findViewById(R.id.tv_date);
        tv_date.setText(currentDate);
        dateNow = currentDate;

        //reset berdasar tanggal
        SharedPreferences foodPreferencesBreakfast = getActivity().getSharedPreferences("FoodPreferencesBreakfast",Context.MODE_PRIVATE);
        dateSP = foodPreferencesBreakfast.getString("Date", dateSP);


//        if (!dateSP.equals(dateNow)) {
//
//            SharedPreferences totalKaloriPreferences = getActivity().getSharedPreferences("PrefTotalKalori", Context.MODE_PRIVATE);
//            SharedPreferences.Editor editor = totalKaloriPreferences.edit();
//            strtextkalorimakanan = (double) totalKaloriPreferences.getFloat("Total Kalori", 0);
//            if (strtextkalorimakanan != null) {
//                editor.clear();
//                editor.commit();
//            }
//        }

        
        //sp kalori tubuh
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        strtext = (double) sharedPreferences.getFloat("Hasil Kalori",0);
        if(strtext != null){
            tv_kebutuhan_kalori_tubuh.setText(String.format("%.2f", strtext));
        }

        //sp kalori makan
        SharedPreferences totalKaloriPreferences = getActivity().getSharedPreferences("PrefTotalKalori", Context.MODE_PRIVATE);
        strtextkalorimakanan = (double) totalKaloriPreferences.getFloat("Total Kalori",0);
        if(strtextkalorimakanan != null){
            tv_batas_kalori_makan.setText(String.format("%.2f", strtextkalorimakanan));
        }

        //kondisi overkalori
        if (strtextkalorimakanan > strtext){

            AlertDialog alertDialog = new AlertDialog.Builder(getActivity())
                    .create();
            alertDialog.setCancelable(false);
            alertDialog.setTitle("OVER KALORI!");
            alertDialog.setMessage("Hati-Hati, Kalori yang Anda Konsumsi Telah Melebihi Kebutuhan Kalori Anda!");
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialog.show();
        }


        //button reset
        mbtn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //reset total kalori makan
                SharedPreferences totalKaloriPreferences = getActivity().getSharedPreferences("PrefTotalKalori", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = totalKaloriPreferences.edit();
                strtextkalorimakanan = (double) totalKaloriPreferences.getFloat("Total Kalori",0);
                if(strtextkalorimakanan != null){
                    editor.clear();
                    editor.commit();

                    SharedPreferences foodPreferencesBreakfast = getActivity().getSharedPreferences("FoodPreferencesBreakfast", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor1 = foodPreferencesBreakfast.edit();
                    String tampHapusPagi = null;
                    editor1.putString("Breakfast", tampHapusPagi);
                    editor1.commit();

                    SharedPreferences foodPreferencesLunch = getActivity().getSharedPreferences("FoodPreferencesLunch", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor2 = foodPreferencesLunch.edit();
                    String tampHapusSiang = null;
                    editor2.putString("Lunch", tampHapusSiang);
                    editor2.commit();

                    SharedPreferences foodPreferencesDinner = getActivity().getSharedPreferences("FoodPreferencesDinner", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor3 = foodPreferencesDinner.edit();
                    String tampHapusMalam = null;
                    editor3.putString("Dinner", tampHapusMalam);
                    editor3.commit();

                    SharedPreferences foodPreferencesSnack = getActivity().getSharedPreferences("FoodPreferencesSnack", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor4 = foodPreferencesSnack.edit();
                    String tampHapusSnack = null;
                    editor4.putString("Snack", tampHapusSnack);
                    editor4.commit();
                }
                initView(rootView);
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_add_breakfast:
                setFoodItemSearchRecyclerView("Breakfast");
                bsbFoodSearch.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
            case R.id.iv_add_lunch:
                setFoodItemSearchRecyclerView("Lunch");
                bsbFoodSearch.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
            case R.id.iv_add_dinner:
                setFoodItemSearchRecyclerView("Dinner");
                bsbFoodSearch.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
            case R.id.iv_add_snack:
                setFoodItemSearchRecyclerView("Snack");
                bsbFoodSearch.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
            case R.id.mbtn_detail_breakfast:
                setFoodDetailRecyclerView("Breakfast");
                bsbFoodDetail.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
            case R.id.mbtn_detail_lunch:
                setFoodDetailRecyclerView("Lunch");
                bsbFoodDetail.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
            case R.id.mbtn_detail_dinner:
                setFoodDetailRecyclerView("Dinner");
                bsbFoodDetail.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
            case R.id.mbtn_detail_snack:
                setFoodDetailRecyclerView("Snack");
                bsbFoodDetail.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
        }

    }


    private void setOnBackPressedCallback() {
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (bsbFoodSearch.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    bsbFoodSearch.setState(BottomSheetBehavior.STATE_COLLAPSED);
                } else if (bsbFoodDetail.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    bsbFoodDetail.setState(BottomSheetBehavior.STATE_COLLAPSED);
                } else {
                    getActivity().finishAffinity();
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), onBackPressedCallback);
    }

    private void setFoodItemSearchRecyclerView(final String kategori) {
        foodItemSearchAdapter = new FoodItemSearchAdapter(getFoodItemsSearch(), getActivity(),
                new FoodItemSearchAdapter.onItemClickListener() {
                    @Override
                    public void onClick(final FoodItem foodItem) {
                        final Spinner dialogSpinner;
                        TextView dialogTvFoodName;
                        final TextView dialogTvFoodCalory;
                        ImageView dialogIvFoodImage;
                        MaterialButton dialogMbtnTambahMakanan;
                        final double beratmakanan = foodItem.getBeratmakanan();
                        final String objDate;

                        Calendar calendar = Calendar.getInstance();
                        final String currentDateSp = DateFormat.getDateInstance().format(calendar.getTime());


                        String[] listFood = {
                                "1 porsi (" + beratmakanan + " gr)",
                                "1/2 porsi (" + beratmakanan * 0.5 + " gr)",
                                "3/4 porsi (" + beratmakanan * 0.75 + " gr)"
                        };
                        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, listFood);

                        final Dialog dialog = new Dialog(getActivity());

                        dialog.setContentView(R.layout.dialog_add_consume_calory);
                        dialogSpinner = dialog.findViewById(R.id.spinner_food_quantity);
                        dialogTvFoodName = dialog.findViewById(R.id.tv_food_name);
                        dialogTvFoodCalory = dialog.findViewById(R.id.tv_food_calory);
                        dialogIvFoodImage = dialog.findViewById(R.id.iv_food_image);
                        dialogMbtnTambahMakanan = dialog.findViewById(R.id.mbtn_tambah_makanan);

                        dialogSpinner.setAdapter(spinnerAdapter);
                        dialogTvFoodName.setText(foodItem.getName());
                        dialogTvFoodCalory.setText(String.format("@%f Kalori", foodItem.getCalory()));
                        Glide.with(getActivity())
                                .load(foodItem.getImageUrl())
                                .placeholder(R.drawable.food_placeholder)
                                .into(dialogIvFoodImage);

                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();


                        Window window = dialog.getWindow();
                        window.setLayout(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);

                        dialogMbtnTambahMakanan.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                TampMakanan.add(foodItem);

                                if (dialogSpinner.getSelectedItem().toString().trim().equals("1 porsi (" + beratmakanan + " gr)")) {
                                    jumlahkalorimakanan = (beratmakanan / foodItem.getBeratmakanan() * foodItem.getCalory());
                                    Toast.makeText(getActivity(), foodItem.getName() + " Telah Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
                                } else if (dialogSpinner.getSelectedItem().toString().trim().equals("1/2 porsi (" + beratmakanan * 0.5 + " gr)")) {
                                    jumlahkalorimakanan = (beratmakanan * 0.5) / foodItem.getBeratmakanan() * foodItem.getCalory();
                                    Toast.makeText(getActivity(), foodItem.getName() + " Telah Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
                                } else if (dialogSpinner.getSelectedItem().toString().trim().equals("3/4 porsi (" + beratmakanan * 0.75 + " gr)")) {
                                    jumlahkalorimakanan = (beratmakanan * 0.75) / foodItem.getBeratmakanan() * foodItem.getCalory();
                                    Toast.makeText(getActivity(), foodItem.getName() + " Telah Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
                                }

                                //SP menyimpan kalorimakanan untuk porsi (nyimpen jumlahakalorimakan yg udh diproses)
                                SharedPreferences porsiMakanPreferences = getActivity().getSharedPreferences("PrefKaloriMakan", Context.MODE_PRIVATE);
                                TampPorsiMakanan = porsiMakanPreferences.getFloat("Porsi Makan", 0);
                                TampPorsiMakanan = (float) jumlahkalorimakanan;
                                Toast.makeText(getActivity(), TampPorsiMakanan + "", Toast.LENGTH_LONG).show();
                                SharedPreferences.Editor editor3 = porsiMakanPreferences.edit();
                                editor3.putFloat("Porsi Makan", TampPorsiMakanan);
                                editor3.apply();

                                //SP untuk totalkalorimakan yg ditambah
                                SharedPreferences totalKaloriPreferences = getActivity().getSharedPreferences("PrefTotalKalori", Context.MODE_PRIVATE);
                                TampKaloriMakan = totalKaloriPreferences.getFloat("Total Kalori",0);
                                TampKaloriMakan += jumlahkalorimakanan;
                                SharedPreferences.Editor editor2 = totalKaloriPreferences.edit();
                                editor2.putFloat("Total Kalori", TampKaloriMakan);
                                editor2.apply();

                                //nampilin langsung hasil penjumlahan
                                SharedPreferences totalKaloriPreferences2 = getActivity().getSharedPreferences("PrefTotalKalori", Context.MODE_PRIVATE);
                                strtextkalorimakanan = (double) totalKaloriPreferences2.getFloat("Total Kalori",0);
                                if(strtextkalorimakanan != null){
                                    tv_batas_kalori_makan.setText(String.format("%.2f", strtextkalorimakanan));
                                }

                                //SP tiap makanan akan disimpan kemana sesuai kategori
                                Gson gson = new Gson();
                                SharedPreferences.Editor editor = null;

                                switch (kategori){
                                    case "Breakfast":
                                        SharedPreferences foodPreferencesBreakfast = getActivity().getSharedPreferences("FoodPreferencesBreakfast", Context.MODE_PRIVATE);
                                        editor = foodPreferencesBreakfast.edit();

                                        objFood = gson.fromJson(foodPreferencesBreakfast.getString(kategori, "[]"), new TypeToken<ArrayList<FoodItem>>(){}.getType());
                                        foodItem.setCalory(jumlahkalorimakanan);
                                        objFood.add(foodItem);
                                        dateSP = currentDateSp;
                                        String jsonBreakfast = gson.toJson(objFood);
                                        editor.putString("Breakfast", jsonBreakfast);
                                        editor.putString("Date", dateSP);
                                        editor.commit();
                                        break;

                                    case "Lunch":
                                        SharedPreferences foodPreferencesLunch = getActivity().getSharedPreferences("FoodPreferencesLunch", Context.MODE_PRIVATE);
                                        editor = foodPreferencesLunch.edit();

                                        objFood = gson.fromJson(foodPreferencesLunch.getString(kategori, "[]"), new TypeToken<ArrayList<FoodItem>>(){}.getType());
                                        foodItem.setCalory(jumlahkalorimakanan);
                                        objFood.add(foodItem);
                                        String jsonLunch = gson.toJson(objFood);
                                        editor.putString("Lunch", jsonLunch);
                                        editor.putString("Date", currentDateSp);
                                        editor.commit();
                                        break;

                                    case "Dinner":
                                        SharedPreferences foodPreferencesDinner = getActivity().getSharedPreferences("FoodPreferencesDinner", Context.MODE_PRIVATE);
                                        editor = foodPreferencesDinner.edit();

                                        objFood = gson.fromJson(foodPreferencesDinner.getString(kategori, "[]"), new TypeToken<ArrayList<FoodItem>>(){}.getType());
                                        foodItem.setCalory(jumlahkalorimakanan);
                                        objFood.add(foodItem);
                                        String jsonDinner = gson.toJson(objFood);
                                        editor.putString("Dinner", jsonDinner);
                                        editor.putString("Date", currentDateSp);
                                        editor.commit();
                                        break;

                                    case "Snack":
                                        SharedPreferences foodPreferencesSnack = getActivity().getSharedPreferences("FoodPreferencesSnack", Context.MODE_PRIVATE);
                                        editor = foodPreferencesSnack.edit();

                                        objFood = gson.fromJson(foodPreferencesSnack.getString(kategori, "[]"), new TypeToken<ArrayList<FoodItem>>(){}.getType());
                                        foodItem.setCalory(jumlahkalorimakanan);
                                        objFood.add(foodItem);
                                        String jsonSnack = gson.toJson(objFood);
                                        editor.putString("Snack", jsonSnack);
                                        editor.putString("Date", currentDateSp);
                                        editor.commit();
                                        break;
                                }
                                dialog.dismiss();
                            }
                        });
                    }
                });
        rvFoodListSearch.setAdapter(foodItemSearchAdapter);
        rvFoodListSearch.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private ArrayList<FoodItem> getFoodItemsSearch() {
        ArrayList<FoodItem> foodItems = new ArrayList<>();

        foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/tantanprojek.appspot.com/o/images%2Fapel_1-removebg-preview%202.png?alt=media&token=b6e5ec33-c9e9-452f-8376-db5cf59fe2d1", "Apel Merah", "Apel Merah Segar", 200, 100));
        foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/tantanprojek.appspot.com/o/images%2Fapel2_1-removebg-preview%202.png?alt=media&token=6a0fd9a8-f3eb-4c9d-98a0-3104e69f9e5b", "Apel Hijau", "Apel Hijau Segar", 300, 100));

        return foodItems;
    }

    private void setFoodDetailRecyclerView(final String kategori) {
        foodDetailListAdapter = new FoodDetailListAdapter(getFoodItemsDetail(kategori), getActivity(),
                new FoodDetailListAdapter.onItemClickListener() {

            //Buat ngehapus makanan
                    @Override
                    public void onClick(final FoodItem foodItem) {
                        ArrayList<FoodItem> foodItems = getFoodItemsDetail(kategori);

                            for (FoodItem item :
                                    foodItems) {
                                if (foodItem.getId().equals(item.getId())) {
                                    foodItems.remove(item);

                                    //SP buat ngambil kalori berdasar porsi (ngambil nilai jumlahkalorimakan)
                                    SharedPreferences porsiMakanPreferences = getActivity().getSharedPreferences("PrefKaloriMakan", Context.MODE_PRIVATE);
                                    TampPorsiMakanan = porsiMakanPreferences.getFloat("Porsi Makan", 0);
                                    Toast.makeText(getActivity(), TampPorsiMakanan + "", Toast.LENGTH_LONG).show();
                                    SharedPreferences.Editor editor3 = porsiMakanPreferences.edit();
                                    editor3.putFloat("Porsi Makan", TampPorsiMakanan);
                                    editor3.apply();

                                    //SP buat totalkalori setelah dikurangin
                                    SharedPreferences totalKaloriPreferences = getActivity().getSharedPreferences("PrefTotalKalori", Context.MODE_PRIVATE);
                                    TampKaloriMakanBaru = totalKaloriPreferences.getFloat("Total Kalori",0);
                                    Toast.makeText(getActivity(), foodItem.getCalory() + "", Toast.LENGTH_LONG).show();
                                    TampKaloriMakanBaru -= TampPorsiMakanan;
                                    SharedPreferences.Editor editor2 = totalKaloriPreferences.edit();
                                    editor2.putFloat("Total Kalori", TampKaloriMakanBaru);
                                    editor2.apply();

                                    //nampilin langsung hasil pengurangan
                                    SharedPreferences totalKaloriPreferences2 = getActivity().getSharedPreferences("PrefTotalKalori", Context.MODE_PRIVATE);
                                    strtextkalorimakanan = (double) totalKaloriPreferences2.getFloat("Total Kalori",0);
                                    if(strtextkalorimakanan != null){
                                        tv_batas_kalori_makan.setText(String.format("%.2f", strtextkalorimakanan));
                                    }
                                    break;
                                }
                            }
                            
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = null;

                        switch(kategori){
                            case "Breakfast":
                                SharedPreferences foodPreferencesBreakfast = getActivity().getSharedPreferences("FoodPreferencesBreakfast", Context.MODE_PRIVATE);
                                editor = foodPreferencesBreakfast.edit();

                                String jsonBreakfast = gson.toJson(foodItems);
                                editor.putString("Breakfast", jsonBreakfast);
                                editor.commit();
                                break;

                            case "Lunch":
                                SharedPreferences foodPreferencesLunch = getActivity().getSharedPreferences("FoodPreferencesLunch", Context.MODE_PRIVATE);
                                editor = foodPreferencesLunch.edit();

                                String jsonLunch = gson.toJson(foodItems);
                                editor.putString("Lunch", jsonLunch);
                                editor.commit();
                                break;

                            case "Dinner":
                                SharedPreferences foodPreferencesDinner = getActivity().getSharedPreferences("FoodPreferencesDinner", Context.MODE_PRIVATE);
                                editor = foodPreferencesDinner.edit();

                                String jsonDinner = gson.toJson(foodItems);
                                editor.putString("Dinner", jsonDinner);
                                editor.commit();
                                break;

                            case "Snack":
                                SharedPreferences foodPreferencesSnack = getActivity().getSharedPreferences("FoodPreferencesSnack", Context.MODE_PRIVATE);
                                editor = foodPreferencesSnack.edit();

                                String jsonSnack = gson.toJson(foodItems);
                                editor.putString("Snack", jsonSnack);
                                editor.commit();
                                break;
                        }

                        bsbFoodDetail.setState(BottomSheetBehavior.STATE_HIDDEN);
                    }
                });

        if (objFood != null) {
            rvFoodDetail.setAdapter(foodDetailListAdapter);
            rvFoodDetail.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
    }

    private ArrayList<FoodItem> getFoodItemsDetail(String kategori) {

        if (kategori.equals("Breakfast")) {
            SharedPreferences foodPreferencesBreakfast = getActivity().getSharedPreferences("FoodPreferencesBreakfast", Context.MODE_PRIVATE);

            Gson gson = new Gson();
            String json = foodPreferencesBreakfast.getString(kategori,"[]");
            objFood = gson.fromJson(json, new TypeToken<ArrayList<FoodItem>>(){}.getType());
            return objFood;

        } else if (kategori.equals("Lunch")) {
            SharedPreferences foodPreferencesLunch = getActivity().getSharedPreferences("FoodPreferencesLunch", Context.MODE_PRIVATE);

            Gson gson = new Gson();
            String json = foodPreferencesLunch.getString(kategori, "[]");
            objFood = gson.fromJson(json, new TypeToken<ArrayList<FoodItem>>(){}.getType());
            return objFood;

        } else if (kategori.equals("Dinner")) {
            SharedPreferences foodPreferencesDinner = getActivity().getSharedPreferences("FoodPreferencesDinner", Context.MODE_PRIVATE);

            Gson gson = new Gson();
            String json = foodPreferencesDinner.getString(kategori, "[]");
            objFood = gson.fromJson(json, new TypeToken<ArrayList<FoodItem>>(){}.getType());
            return objFood;
        } else {
            SharedPreferences foodPreferencesSnack = getActivity().getSharedPreferences("FoodPreferencesSnack", Context.MODE_PRIVATE);

            Gson gson = new Gson();
            String json = foodPreferencesSnack.getString(kategori, "[]");
            objFood = gson.fromJson(json, new TypeToken<ArrayList<FoodItem>>(){}.getType());
            return objFood;
        }
    }

}



