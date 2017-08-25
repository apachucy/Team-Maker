package unii.entertainment.teammaker.category.model;

public class Category {
    public static final long EMPTY_ID = -1L;
    public static final int NO_PERSONS = 0;
    private Long id;
    private String categoryName;

    private int personsInCategory;

    //Add number of people in category
    public Category() {
        id = EMPTY_ID;
        personsInCategory = NO_PERSONS;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPersonsInCategory() {
        return personsInCategory;
    }

    public void setPersonsInCategory(int personsInCategory) {
        this.personsInCategory = personsInCategory;
    }
}
