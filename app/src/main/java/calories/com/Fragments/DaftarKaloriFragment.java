package calories.com.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import calories.com.Adapter.FoodCategoryListAdapter;
import calories.com.Adapter.FoodItemListAdapter;
import calories.com.Model.FoodCategory;
import calories.com.Model.FoodItem;
import calories.com.R;

public class DaftarKaloriFragment extends Fragment {

    private TextView tvHeaderTitle;
    private RecyclerView rvFoodList;

    private FoodCategoryListAdapter adapterFoodCategoryList;
    private FoodItemListAdapter adapterFoodItemList;
    private boolean isShowingFoodItem;

    public DaftarKaloriFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_daftar_kalori, container, false);

        setOnBackPressedCallback();
        initView(root);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        setFoodCategoryRecyclerView();
    }

    private void setOnBackPressedCallback(){
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed(){
                if(isShowingFoodItem){
                    isShowingFoodItem = false;
                    setFoodCategoryRecyclerView();
                    tvHeaderTitle.setText("Daftar Kalori Makanan dan Minuman");
                } else {
                    getActivity().finish();
                }
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), onBackPressedCallback);
    }

    private void initView(View rootView){
        isShowingFoodItem = false;

        rvFoodList = rootView.findViewById(R.id.rv_food_list);
        tvHeaderTitle = rootView.findViewById(R.id.tv_header_title);
    }

    private void setFoodCategoryRecyclerView() {
        adapterFoodCategoryList = new FoodCategoryListAdapter(getFoodCategories(),
                new FoodCategoryListAdapter.onItemClickListener() {
                    @Override
                    public void onClick(FoodCategory foodCategory) {
                        isShowingFoodItem = true;
                        setFoodItemRecyclerView();
                        tvHeaderTitle.setText(String.format("Kalori %s", foodCategory.getTitle()));
                    }
                });
        rvFoodList.setAdapter(adapterFoodCategoryList);
        rvFoodList.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    }

    private void setFoodItemRecyclerView() {
        adapterFoodItemList = new FoodItemListAdapter(getFoodItems(), getActivity());
        rvFoodList.setAdapter(adapterFoodItemList);
        rvFoodList.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private ArrayList<FoodCategory> getFoodCategories(){
        ArrayList<FoodCategory> foodCategories = new ArrayList<>();

        foodCategories.add(new FoodCategory(0, R.drawable.ic_main_foods, "Makanan Pokok"));
        foodCategories.add(new FoodCategory(1, R.drawable.ic_side_dishes, "Lauk Pauk"));
        foodCategories.add(new FoodCategory(2, R.drawable.ic_vegetables, "Sayuran"));
        foodCategories.add(new FoodCategory(3, R.drawable.ic_fruits, "Buah-buahan"));
        foodCategories.add(new FoodCategory(4, R.drawable.ic_snacks, "Makanan Ringan"));
        foodCategories.add(new FoodCategory(5, R.drawable.ic_drinks, "Minuman"));

        return foodCategories;
    }

    private ArrayList<FoodItem> getFoodItems() {
        ArrayList<FoodItem> foodItems = new ArrayList<>();

        foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasgor%20(2).png?alt=media&token=3fca6792-cddf-4f21-86a5-2167ea5f262e", "Nasi Goreng", "Nasi goreng dengan potongan sayur.", 200));
        foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasi.png?alt=media&token=4967ab76-ef5a-4b0f-b85d-95561c4c69b0", "Nasi Putih", "Dibuat dari beras pilihan.", 300));
        foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/rotitawar-removebg-preview.png?alt=media&token=73a0043d-a384-4187-8724-a9566dfa967c", "Roti Tawar", "Roti tawar putih dibuat dari tepung pilihan", 150));
        foodItems.add(new FoodItem("", "", "Nasi Telur", "dibuat dari potongan-potongan ayam yang digoreng dengan minya zaitun.", 350));
        foodItems.add(new FoodItem("", "", "Mie dok dok", "dibuat dari potongan-potongan ayam yang digoreng dengan minya zaitun.", 210));
        foodItems.add(new FoodItem("", "", "Intel", "dibuat dari potongan-potongan ayam yang digoreng dengan minya zaitun.", 120));

        return foodItems;
    }


}

