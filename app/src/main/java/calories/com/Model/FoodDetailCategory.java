package calories.com.Model;


public class FoodDetailCategory {
    private int id;
    private String kategori;

    public FoodDetailCategory(int id, String kategori) {
        this.id = id;
        this.kategori = kategori;

    }

    public int getId() {
        return id;
    }

    public String getKategori(){
        return kategori;
    }
}