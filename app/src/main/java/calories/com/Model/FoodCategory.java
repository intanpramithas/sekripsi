package calories.com.Model;


public class FoodCategory {
    private int id;
    private int imageId;
    private String title;
    private String kategori;

    public FoodCategory(int id, int imageId, String title) {
        this.id = id;
        this.imageId = imageId;
        this.title = title;
        this.kategori = kategori;

    }

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getKategori(){
        return kategori;
    }
}