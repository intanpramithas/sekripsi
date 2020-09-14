package calories.com.Fragments;

import android.app.Dialog;
import android.content.Context;
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

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

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

    final ArrayList<FoodItem> TampMakanan = new ArrayList<>();
    private TextView tv_batas_kalori_tubuh;
    private Double strtext;
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
    //    private ImageView ivHapusFood;
    private MaterialButton mbtn_detail_breakfast;
    private MaterialButton mbtn_detail_lunch;
    private MaterialButton mbtn_detail_dinner;
    private MaterialButton mbtn_detail_snack;
    private MaterialButton mtbn_tambah_makanan;
    private RecyclerView rvFoodListSearch;
    private RecyclerView rvFoodDetail;
    private double jumlahkalorimakanan;
    private ArrayList<FoodItem> objFood;
    private boolean isShowingFoodItem;
    private FoodItemDataSource dataSource;
    private int categoryId;

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


    public void initView(View rootView) {

        tv_batas_kalori_tubuh = rootView.findViewById(R.id.tv_batas_kalori_tubuh);
        llFoodSearchContainer = rootView.findViewById(R.id.ll_bottomsheet_container);
        llFoodDetailContainer = rootView.findViewById(R.id.ll_bottomsheet_container_detail);
        ivAddBreakfast = rootView.findViewById(R.id.iv_add_breakfast);
        ivAddLunch = rootView.findViewById(R.id.iv_add_lunch);
        ivAddDinner = rootView.findViewById(R.id.iv_add_dinner);
        ivAddSnack = rootView.findViewById(R.id.iv_add_snack);
//        ivHapusFood = rootView.findViewById(R.id.iv_hapus_food);
        mbtn_detail_breakfast = rootView.findViewById(R.id.mbtn_detail_breakfast);
        mbtn_detail_lunch = rootView.findViewById(R.id.mbtn_detail_lunch);
        mbtn_detail_dinner = rootView.findViewById(R.id.mbtn_detail_dinner);
        mbtn_detail_snack = rootView.findViewById(R.id.mbtn_detail_snack);
        rvFoodListSearch = rootView.findViewById(R.id.rv_food_list_search);
        rvFoodDetail = rootView.findViewById(R.id.rv_food_detail);

        bsbFoodSearch = BottomSheetBehavior.from(llFoodSearchContainer);
        bsbFoodDetail = BottomSheetBehavior.from(llFoodDetailContainer);

        ivAddBreakfast.setOnClickListener(this);
        ivAddLunch.setOnClickListener(this);
        ivAddDinner.setOnClickListener(this);
        ivAddSnack.setOnClickListener(this);
//        ivHapusFood.setOnClickListener(this);

        mbtn_detail_breakfast.setOnClickListener(this);
        mbtn_detail_lunch.setOnClickListener(this);
        mbtn_detail_dinner.setOnClickListener(this);
        mbtn_detail_snack.setOnClickListener(this);

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

                        String[] listFood = {
                                "1 porsi (" + beratmakanan + " gr)",
                                "1/2 porsi (" + beratmakanan * 0.5 + " gr)",
                                "3/4 porsi (" + beratmakanan * 0.75 + " gr)"
                        };
                        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, listFood);

                        Dialog dialog = new Dialog(getActivity());

                        dialog.setContentView(R.layout.dialog_add_consume_calory);
                        dialogSpinner = dialog.findViewById(R.id.spinner_food_quantity);
                        dialogTvFoodName = dialog.findViewById(R.id.tv_food_name);
                        dialogTvFoodCalory = dialog.findViewById(R.id.tv_food_calory);
                        dialogIvFoodImage = dialog.findViewById(R.id.iv_food_image);
                        dialogMbtnTambahMakanan = dialog.findViewById(R.id.mbtn_tambah_makanan);

                        dialogSpinner.setAdapter(spinnerAdapter);
                        dialogTvFoodName.setText(foodItem.getName());
                        dialogTvFoodCalory.setText(String.format("@%d Kalori", foodItem.getCalory()));
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
                                    jumlahkalorimakanan = beratmakanan / foodItem.getBeratmakanan() * foodItem.getCalory();
                                    Toast.makeText(getActivity(), jumlahkalorimakanan + "", Toast.LENGTH_SHORT).show();
                                } else if (dialogSpinner.getSelectedItem().toString().trim().equals("1/2 porsi (" + beratmakanan * 0.5 + " gr)")) {
                                    jumlahkalorimakanan = (beratmakanan * 0.5) / foodItem.getBeratmakanan() * foodItem.getCalory();
                                    Toast.makeText(getActivity(), jumlahkalorimakanan + "", Toast.LENGTH_SHORT).show();
                                } else if (dialogSpinner.getSelectedItem().toString().trim().equals("3/4 porsi (" + beratmakanan * 0.75 + " gr)")) {
                                    jumlahkalorimakanan = (beratmakanan * 0.75) / foodItem.getBeratmakanan() * foodItem.getCalory();
                                    Toast.makeText(getActivity(), jumlahkalorimakanan + "", Toast.LENGTH_SHORT).show();
                                }



                                Gson gson = new Gson();
                                SharedPreferences.Editor editor = null;
                                switch (kategori){
                                    case "Breakfast":
                                        SharedPreferences foodPreferencesBreakfast = getActivity().getSharedPreferences("FoodPreferencesBreakfast", Context.MODE_PRIVATE);
                                        editor = foodPreferencesBreakfast.edit();


                                        objFood = gson.fromJson(foodPreferencesBreakfast.getString(kategori, "[]"), new TypeToken<ArrayList<FoodItem>>() {}.getType());
                                        objFood.add(foodItem);
                                        String jsonBreakfast = gson.toJson(objFood);
                                        editor.putString("Breakfast", jsonBreakfast);
                                        editor.commit();
                                        break;

                                    case "Lunch":
                                        SharedPreferences foodPreferencesLunch = getActivity().getSharedPreferences("FoodPreferencesLunch", Context.MODE_PRIVATE);
                                        editor = foodPreferencesLunch.edit();

                                        objFood = gson.fromJson(foodPreferencesLunch.getString(kategori, "[]"), new TypeToken<ArrayList<FoodItem>>(){}.getType());
                                        objFood.add(foodItem);
                                        String jsonLunch = gson.toJson(objFood);
                                        editor.putString("Lunch", jsonLunch);
                                        editor.commit();
                                        break;

                                    case "Dinner":
                                        SharedPreferences foodPreferencesDinner = getActivity().getSharedPreferences("FoodPreferencesDinner", Context.MODE_PRIVATE);
                                        editor = foodPreferencesDinner.edit();

                                        objFood = gson.fromJson(foodPreferencesDinner.getString(kategori, "[]"), new TypeToken<ArrayList<FoodItem>>(){}.getType());
                                        objFood.add(foodItem);
                                        String jsonDinner = gson.toJson(objFood);
                                        editor.putString("Dinner", jsonDinner);
                                        editor.commit();
                                        break;

                                    case "Snack":
                                        SharedPreferences foodPreferencesSnack = getActivity().getSharedPreferences("FoodPreferencesSnack", Context.MODE_PRIVATE);
                                        editor = foodPreferencesSnack.edit();

                                        objFood = gson.fromJson(foodPreferencesSnack.getString(kategori, "[]"), new TypeToken<ArrayList<FoodItem>>(){}.getType());
                                        objFood.add(foodItem);
                                        String jsonSnack = gson.toJson(objFood);
                                        editor.putString("Snack", jsonSnack);
                                        editor.commit();
                                        break;
                                }


//
//                                } else if (view.getId() == ivAddSnack.getId()){
//
//                                    SharedPreferences foodPreferencesSnack = getActivity().getSharedPreferences("FoodPreferencesSnack", Context.MODE_PRIVATE);
//                                    SharedPreferences.Editor editor = foodPreferencesSnack.edit();
//
//                                    Gson gson = new Gson();
//                                    objFood = gson.fromJson(foodPreferencesSnack.getString("Snack", "[]"), new TypeToken<ArrayList<FoodItem>>(){}.getType());
//                                    objFood.add(foodItem);
//                                    String json = gson.toJson(objFood);
//                                    editor.putString("Snack", json);
//                                    editor.commit();
//
//                                }
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

                    @Override
                    public void onClick(final FoodItem foodItem) {
                        ArrayList<FoodItem> foodItems = getFoodItemsDetail(kategori);
                        for (FoodItem item :
                                foodItems) {
                            if (foodItem.getId().equals(item.getId())){
                                foodItems.remove(item);
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
            String json = foodPreferencesBreakfast.getString(kategori, "[]");
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



