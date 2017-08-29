package unii.entertainment.teammaker.category.viewmodel;


import java.util.List;

import javax.inject.Inject;

import unii.entertainment.teammaker.base.BaseViewModel;
import unii.entertainment.teammaker.category.model.Category;
import unii.entertainment.teammaker.dagger.ActivityComponent;
import unii.entertainment.teammaker.persitence.TeamMakerDatabase;

public class CategoryListViewModel extends BaseViewModel {
    private List<Category> categoryList;

    @Inject
    TeamMakerDatabase teamMakerDatabase;

    public CategoryListViewModel(ActivityComponent component) {
        component.inject(this);
        categoryList = teamMakerDatabase.getAllCategories();
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public boolean categoryExist(String categoryName) {
        return teamMakerDatabase.isCategoryExist(categoryName);
    }

    public boolean categoryWithPlayersExist() {
        List<Category> allCategories = teamMakerDatabase.getAllCategoriesWithPlayers();
        return !allCategories.isEmpty();
    }

    public boolean addCategory(String categoryName) {
        //false if category exist

        Category category = new Category();
        category.setCategoryName(categoryName);
        category.setPersonsInCategory(0);
        teamMakerDatabase.saveCategory(category);
        return categoryList.add(category);
    }
}
