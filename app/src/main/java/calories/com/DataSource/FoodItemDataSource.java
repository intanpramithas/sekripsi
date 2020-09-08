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
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/bakso%20copy.png?alt=media&token=50611acd-8379-4f73-957c-9bda7591ef2a", "Bakso Daging Sapi", "Satu Porsi Bakso Daging Sapi Nikmat", 218,108));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/tahugoreng.png?alt=media&token=99c4f5ea-6107-40bb-a720-7a0455811850", "Tahu Goreng", "Satu Porsi Tahu Goreng Lembut", 271,100));
                break;
            case 2:
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/sayurasem.jpg?alt=media&token=661c926e-cb87-47b2-a6a7-bcd2c04c3ad2", "Sayur Asem", "Satu Porsi Sayur Asem Khas Jawa Tengah.", 80,240));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/sayurbeningbayam.jpg?alt=media&token=6bc21bbc-9a5c-499e-872a-2d2e2658072f", "Sayur Bening Bayam", "Satu Porsi Sayur Bening Bayam Yang Enak", 43,120));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/lodeh.jpg?alt=media&token=b8e5013f-a65d-4bdd-bb8f-95f5327e3c76", "Sayur Lodeh", "Satu Porsi Sayur Lodeh Enak", 70,108));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/tumiskangkung.jpg?alt=media&token=618024b3-0796-4c4d-8702-cdff52b2b38b", "Tumis Kangkung", "Satu Piring Tumis Kangkung Enak.", 200,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/tumiskacangpanjang.jpg?alt=media&token=07ae57c5-2eda-4de3-9588-11b75911dc8a", "Tumis Kacang Panjang", "Satu Piring Tumis Kacang Panjang Enak", 155,110));
                break;
            case 3:
                foodItems.add(new FoodItem("", "", "Apel Merah", "Satu Buah Apel Merah Lezat", 82,140));
                foodItems.add(new FoodItem("", "", "Apel Hijau", "Satu Buah Apel Hijau Lezat", 72,140));
                foodItems.add(new FoodItem("", "", "Jeruk Sunkist", "Satu Buah Jeruk Sunkist Segar", 40,200));
                foodItems.add(new FoodItem("", "", "Pisang", "Satu Buah Pisang Nikmat", 90,100));
                foodItems.add(new FoodItem("", "", "Pir", "Satu Buah Pir Lezat", 80,200));
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



