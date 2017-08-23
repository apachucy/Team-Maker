package unii.entertainment.teammaker.category.model;

public class Category {

    private int id;
    private String categoryName;
    //Add number of people in category

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
