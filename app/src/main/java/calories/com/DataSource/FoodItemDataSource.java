package calories.com.DataSource;

import java.util.ArrayList;

import calories.com.Model.FoodItem;

public class FoodItemDataSource {

    public ArrayList<FoodItem> getFoodItems(int categoryId) {
        ArrayList<FoodItem> foodItems = new ArrayList<>();

        switch (categoryId) {
            case 0:
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasgor%20(2).png?alt=media&token=3fca6792-cddf-4f21-86a5-2167ea5f262e", "Nasi Goreng", "Nasi goreng dengan potongan sayur.", 200, 100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasi.png?alt=media&token=4967ab76-ef5a-4b0f-b85d-95561c4c69b0", "Nasi Putih", "Nasi putih terbuat dari beras pilihan.", 200,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/rotitawar-removebg-preview.png?alt=media&token=73a0043d-a384-4187-8724-a9566dfa967c", "Roti Tawar", "Roti yang terbuat dari tepung berkualitas", 200, 100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/kntg.jpg?alt=media&token=b0625134-b8b5-475f-b38a-83421d973601", "Kentang Rebus", "Sepotong kentang rebus nikmat", 200,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/indomiegoreng.jpg?alt=media&token=9f89e2ff-4dc2-4a5e-80d1-a57bfb3c6444", "Indomie Goreng", "Satu porsi Indomie goreng polos", 380,100));
                break;
            case 1:
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/pahakfc.png?alt=media&token=37fbb696-5161-496f-9c66-10ccb790354b", "Ayam Goreng KFC (paha bawah)", "Sepotong Ayam KFC bagian paha bawah.", 170,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/telordadar.png?alt=media&token=81c2fb7f-dce5-4d8b-8811-1355b9ff5d77", "Telur Dadar", "Telur Dadar Pilihan", 93,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nilagoreng.png?alt=media&token=93860dc1-5fde-4b76-b432-887c1f5daa83", "Nila Goreng", "Sepotong Ikan Nila Goreng Yang Enak", 128,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nilagoreng.png?alt=media&token=93860dc1-5fde-4b76-b432-887c1f5daa83", "Nila Goreng", "Sepotong Ikan Nila Goreng Yang Enak", 128,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nilagoreng.png?alt=media&token=93860dc1-5fde-4b76-b432-887c1f5daa83", "Nila Goreng", "Sepotong Ikan Nila Goreng Yang Enak", 128,100));
                break;
            case 2:
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasgor%20(2).png?alt=media&token=3fca6792-cddf-4f21-86a5-2167ea5f262e", "Nasi Goreng", "Nasi goreng dengan potongan sayur.", 200,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasgor%20(2).png?alt=media&token=3fca6792-cddf-4f21-86a5-2167ea5f262e", "Nasi Goreng", "Nasi goreng dengan potongan sayur.", 200,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasgor%20(2).png?alt=media&token=3fca6792-cddf-4f21-86a5-2167ea5f262e", "Nasi Goreng", "Nasi goreng dengan potongan sayur.", 200,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasgor%20(2).png?alt=media&token=3fca6792-cddf-4f21-86a5-2167ea5f262e", "Nasi Goreng", "Nasi goreng dengan potongan sayur.", 200,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasgor%20(2).png?alt=media&token=3fca6792-cddf-4f21-86a5-2167ea5f262e", "Nasi Goreng", "Nasi goreng dengan potongan sayur.", 200,100));
                break;
            case 3:
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasgor%20(2).png?alt=media&token=3fca6792-cddf-4f21-86a5-2167ea5f262e", "Nasi Goreng", "Nasi goreng dengan potongan sayur.", 200,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasgor%20(2).png?alt=media&token=3fca6792-cddf-4f21-86a5-2167ea5f262e", "Nasi Goreng", "Nasi goreng dengan potongan sayur.", 200,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasgor%20(2).png?alt=media&token=3fca6792-cddf-4f21-86a5-2167ea5f262e", "Nasi Goreng", "Nasi goreng dengan potongan sayur.", 200,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasgor%20(2).png?alt=media&token=3fca6792-cddf-4f21-86a5-2167ea5f262e", "Nasi Goreng", "Nasi goreng dengan potongan sayur.", 200,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasgor%20(2).png?alt=media&token=3fca6792-cddf-4f21-86a5-2167ea5f262e", "Nasi Goreng", "Nasi goreng dengan potongan sayur.", 200,100));
                break;
            case 4:
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasgor%20(2).png?alt=media&token=3fca6792-cddf-4f21-86a5-2167ea5f262e", "Nasi Goreng", "Nasi goreng dengan potongan sayur.", 200,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasgor%20(2).png?alt=media&token=3fca6792-cddf-4f21-86a5-2167ea5f262e", "Nasi Goreng", "Nasi goreng dengan potongan sayur.", 200,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasgor%20(2).png?alt=media&token=3fca6792-cddf-4f21-86a5-2167ea5f262e", "Nasi Goreng", "Nasi goreng dengan potongan sayur.", 200,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasgor%20(2).png?alt=media&token=3fca6792-cddf-4f21-86a5-2167ea5f262e", "Nasi Goreng", "Nasi goreng dengan potongan sayur.", 200,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasgor%20(2).png?alt=media&token=3fca6792-cddf-4f21-86a5-2167ea5f262e", "Nasi Goreng", "Nasi goreng dengan potongan sayur.", 200,100));
                break;
            case 5:
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasgor%20(2).png?alt=media&token=3fca6792-cddf-4f21-86a5-2167ea5f262e", "Nasi Goreng", "Nasi goreng dengan potongan sayur.", 200,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasgor%20(2).png?alt=media&token=3fca6792-cddf-4f21-86a5-2167ea5f262e", "Nasi Goreng", "Nasi goreng dengan potongan sayur.", 200,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasgor%20(2).png?alt=media&token=3fca6792-cddf-4f21-86a5-2167ea5f262e", "Nasi Goreng", "Nasi goreng dengan potongan sayur.", 200,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasgor%20(2).png?alt=media&token=3fca6792-cddf-4f21-86a5-2167ea5f262e", "Nasi Goreng", "Nasi goreng dengan potongan sayur.", 200,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasgor%20(2).png?alt=media&token=3fca6792-cddf-4f21-86a5-2167ea5f262e", "Nasi Goreng", "Nasi goreng dengan potongan sayur.", 200,100));
                break;
        }
        return foodItems;
    }
}



