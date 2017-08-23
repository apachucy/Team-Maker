package unii.entertainment.teammaker.category.persistence;

import java.util.List;

import unii.entertainment.teammaker.category.model.Category;

public interface CategoryDao {
    void save(Category category);

    //TODO: ważne - nie używać słów których używa sql jako nazwy tabeli...
    public Category loadCategoryById(int cId);


    public List<Category> loadAllCategory();

    void remove(Category category);

    void update(Category category);
}
