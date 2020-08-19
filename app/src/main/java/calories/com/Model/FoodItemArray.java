package calories.com.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class FoodItemArray {

    @SerializedName("fooditem")

    private ArrayList<FoodItem> foodItemArrayList;
    public ArrayList<FoodItem> getFoodItemArrayList(){

        return foodItemArrayList;
    }
}
