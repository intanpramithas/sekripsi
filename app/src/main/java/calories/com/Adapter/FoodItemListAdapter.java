package calories.com.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import calories.com.Model.FoodItem;
import calories.com.R;


public class FoodItemListAdapter extends RecyclerView.Adapter<FoodItemListAdapter.ViewHolder> {
    private ArrayList<FoodItem> foodItems;
    private Context context;

    public FoodItemListAdapter(ArrayList foodItems, Context context){
        this.foodItems =foodItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food_item_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        holder.bind(foodItems.get(position));
    }

    @Override
    public int getItemCount(){
        return foodItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivFoodImage;
        private TextView tvFoodName;
        private TextView tvFoodDescription;
        private TextView tvFoodCalory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoodImage = itemView.findViewById(R.id.iv_food_image);
            tvFoodCalory = itemView.findViewById(R.id.tv_food_calory);
            tvFoodDescription = itemView.findViewById(R.id.tv_food_description);
            tvFoodName = itemView.findViewById(R.id.tv_food_name);
        }

        public void bind(FoodItem foodItem){
            tvFoodName.setText(foodItem.getName());
            tvFoodDescription.setText(foodItem.getDescription());
            tvFoodCalory.setText(String.format("%.0f  Kalori", foodItem.getCalory()));

            Glide.with(context)
                    .load(foodItem.getImageUrl())
                    .placeholder(R.drawable.food_placeholder)
                    .into(ivFoodImage);
        }
    }
}
