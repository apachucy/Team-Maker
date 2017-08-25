package unii.entertainment.teammaker.category.viewmodel;


import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import unii.entertainment.teammaker.base.BaseViewModel;
import unii.entertainment.teammaker.category.model.Category;

public class CategoryListViewModel extends BaseViewModel {

    private List<Category> categoryList;
    private Map<Long, Integer> playersInSelectedCategory;

    public CategoryListViewModel() {
        categoryList = new ArrayList<>();
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }



    @Nullable
    public Integer countPlayersWithCategoryId(Long categoryId) {
        return 6;
        //return playersInSelectedCategory.get(categoryId);
    }



    public boolean addCategory(String categoryName) {
        //false if category exist

        Category category = new Category();
        category.setCategoryName(categoryName);
        //TODO: remove me!
        category.setId(2L);
        categoryList.add(category);
        return true;
    }
}
