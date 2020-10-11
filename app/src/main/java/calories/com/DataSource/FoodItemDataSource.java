package calories.com.DataSource;

import java.util.ArrayList;

import calories.com.Model.FoodItem;

public class FoodItemDataSource {

    public ArrayList<FoodItem> getFoodItems(int categoryId) {
        ArrayList<FoodItem> foodItems = new ArrayList<>();

        switch (categoryId) {
            case 0:
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasgor%20(2).png?alt=media&token=3fca6792-cddf-4f21-86a5-2167ea5f262e", "Nasi Goreng", "Satu porsi nasi goreng", 250, 149));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nasi.png?alt=media&token=4967ab76-ef5a-4b0f-b85d-95561c4c69b0", "Nasi Putih", "Satu porsi nasi putih", 180,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/rotitawar-removebg-preview.png?alt=media&token=73a0043d-a384-4187-8724-a9566dfa967c", "Roti Tawar", "Roti tawar putih", 100, 37));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/kntg.jpg?alt=media&token=b0625134-b8b5-475f-b38a-83421d973601", "Kentang Rebus", "Satu buah kentang rebus", 87,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/indomie.png?alt=media&token=11c99d86-14a1-47a9-ba52-a77563e1d42b", "Indomie Goreng", "Satu Porsi Indomie Goreng", 380, 85));
                break;
            case 1:
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/pahakfc.png?alt=media&token=37fbb696-5161-496f-9c66-10ccb790354b", "Ayam Goreng KFC (paha bawah)", "Sepotong Ayam KFC bagian paha bawah.", 219,74));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/telordadar.png?alt=media&token=81c2fb7f-dce5-4d8b-8811-1355b9ff5d77", "Telur Dadar", "Telur Dadar Pilihan", 93,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/nilagoreng.png?alt=media&token=93860dc1-5fde-4b76-b432-887c1f5daa83", "Ikan Goreng", "Satu potong Ikan Goreng", 75,40));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/rendang.png?alt=media&token=a00806c9-a68b-4d8d-9534-34d3bb6ef44b", "Rendang Daging", "Satu porsi rendang daging", 212,54));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/bebekgoreng.png?alt=media&token=10cd9572-4b0c-4b83-84b1-599d0c3341ac", "Bebek Goreng", "Satu porsi bebek goreng", 263, 100));
                break;
            case 2:
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/capcay.png?alt=media&token=a1bfc480-eeb9-4645-8138-d39ace5506b1", "Cap cay", "Satu porsi cap cay sayur", 97,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/gadogado.png?alt=media&token=edf058f2-bac6-4f2c-9acd-f9aa3045f7a8", "Gado-gado", "Satu porsi gado-gado", 137,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/rujakcingoer.png?alt=media&token=f4f7146d-7702-4be1-87ba-ff944ba65f1d", "Rujak Cingur", "Satu porsi rujak cingur", 153,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/sayurasem.png?alt=media&token=a5f947b0-6588-498e-be74-53ccc0a80372", "Sayur Asem", "Satu porsi sayur asem", 29,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/semurjengkol.png?alt=media&token=fac08ff0-8f7d-4a3b-baf2-9d784b42669e", "Semur Jengkol", "Satu porsi semur jengkol", 212,100));
                break;
            case 3:
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/apelmalang.png?alt=media&token=3a3e52ee-381f-4453-87ca-15efd8343b26", "Apel Malang", "Satu buah apel malang ukuran medium ", 95,182));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/jeruksunkist.png?alt=media&token=9c33ad73-28ad-4bf0-b0ee-7d038e6d5a14", "Jeruk Sunkist", "Satu buah jeruk sunkist ukuran medium", 62,131));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/pisang.png?alt=media&token=5080cf3e-e3c3-473f-b5a0-30b957b838cf", "Pisang", "Satu buah pisang ukuran medium", 105,118));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/pir.png?alt=media&token=dd766f8a-2ad3-4124-af04-590fffb12dd7", "Pir", "Satu buah pir ukuran medium", 101,178));
                break;
            case 4:
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/kentangmcd.png?alt=media&token=ffb3a126-cdb7-4ad7-8081-d97d0a876654", "Kentang Goreng McD", "1 porsi kentang goreng McD", 378,117));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/biskuit.png?alt=media&token=95537165-7137-468f-a89d-344b3d3b6ec8", "Biskuit", "Satu biji biskuit", 260,75));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/pasteltutup.png?alt=media&token=81175a6c-1503-41d1-bef1-f312c2d5de1c", "Pastel Tutup", "Satu buah pastel tutup", 307,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/eskrim.png?alt=media&token=3f0344e8-13a0-486e-b37e-4dbfae69a473", "Es Krim", "Satu porsi es krim", 210,100));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/dodolnanas.png?alt=media&token=349c9577-e341-49c3-88b8-ef95fa83d72d", "Dodol Nanas", "Dodol rasa nanas", 338,100));
                break;
            case 5:
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/cola.png?alt=media&token=60e0fe1e-f826-4d1d-b1cc-965e5ff3ecbb", "Coca-Cola Botol", "Satu botol cocacola", 170,117));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/esteh.png?alt=media&token=7fb3094d-32d5-4742-8a70-133463f057d0", "Es Teh", "Satu porsi es teh", 68,178));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/susu.png?alt=media&token=9102275a-6ab1-4401-9a3c-6e7f5e066d2c", "Susu", "Satu porsi susu", 122,244));
                foodItems.add(new FoodItem("", "https://firebasestorage.googleapis.com/v0/b/calories-5c69d.appspot.com/o/ultra.png?alt=media&token=97709fe5-24fa-4e27-ad78-94d5b8043b88", "Susu Ultra Cokelat", "Satu porsi susu ultra cokelat", 200,250));
                break;
        }
        return foodItems;
    }
}



