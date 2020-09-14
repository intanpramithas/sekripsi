package calories.com.Model;

public class FoodItem {
    private String id;
    private String imageUrl;
    private String name;
    private String description;
    private int calory;
    private int beratmakanan;

    public FoodItem(String id, String imageUrl, String name, String description, int calory, int beratmakanan) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.description = description;
        this.calory = calory;
        this.beratmakanan = beratmakanan;
    }

    public String getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public int getCalory() {
        return calory;
    }

    public String getDescription() {
        return description;
    }

    public int getBeratmakanan(){
        return  beratmakanan;
    }
}
