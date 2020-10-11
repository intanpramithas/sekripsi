package calories.com.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;

import java.util.ArrayList;

import calories.com.Model.FoodItem;
import calories.com.R;

public class FoodDetailListAdapter extends RecyclerView.Adapter<FoodDetailListAdapter.ViewHolder> {

    private ArrayList<FoodItem> foodItems;
    private Context context;
    private FoodDetailListAdapter.onItemClickListener listener;

    public FoodDetailListAdapter(ArrayList<FoodItem> foodItems, Context context, FoodDetailListAdapter.onItemClickListener listener){
        this.foodItems = foodItems;
        this.context = context;
        this.listener = listener;
        Log.d("ARRAYLIST", new Gson().toJson(foodItems));
    }

    @NonNull
    @Override
    public FoodDetailListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_konsumsikalori, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodDetailListAdapter.ViewHolder holder, int position){
        holder.bind(foodItems.get(position));
    }

    @Override
    public int getItemCount(){
        return foodItems.size();
    }

    public interface onItemClickListener {
        void onClick(FoodItem foodItem);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivFoodImage;
        private TextView tvFoodName;
        private TextView tvFoodDescription;
        private TextView tvFoodCalory;
        private TextView tvFoodTimeEat;
        private MaterialButton mbtnFoodDetail;
        private ImageView ivHapusFood;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoodImage = itemView.findViewById(R.id.iv_food_image);
            tvFoodCalory = itemView.findViewById(R.id.tv_food_calory);
            tvFoodDescription = itemView.findViewById(R.id.tv_food_description);
            tvFoodName = itemView.findViewById(R.id.tv_food_name);
            tvFoodTimeEat = itemView.findViewById(R.id.tv_time_eat);
            mbtnFoodDetail = itemView.findViewById(R.id.mbtn_tambah_makanan);
            ivHapusFood = itemView.findViewById(R.id.iv_hapus_food);
        }

        public void bind(final FoodItem foodItem){
            tvFoodName.setText(foodItem.getName());
            tvFoodDescription.setText(foodItem.getDescription());
            tvFoodCalory.setText(String.format("%.0f Kalori", foodItem.getCalory()));
            tvFoodTimeEat.setText("Jam Makan : " + foodItem.getTime());

            Glide.with(context)
                    .load(foodItem.getImageUrl())
                    .placeholder(R.drawable.food_placeholder)
                    .into(ivFoodImage);

            ivHapusFood.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    listener.onClick(foodItem);
                }
            });
        }
    }
}
