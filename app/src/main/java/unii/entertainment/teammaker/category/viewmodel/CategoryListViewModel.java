package unii.entertainment.teammaker.category.viewmodel;


import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import unii.entertainment.teammaker.base.BaseViewModel;
import unii.entertainment.teammaker.category.model.Category;
import unii.entertainment.teammaker.persitence.TeamMakerDatabase;
import unii.entertainment.teammaker.player.persistance.PlayerDao;

public class CategoryListViewModel extends BaseViewModel {

    private List<Category> categoryList;
    private Map<Integer, Integer> playersInSelectedCategory;

    public CategoryListViewModel() {
        categoryList = new ArrayList<>();
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void init(TeamMakerDatabase teamMakerDatabase) {
        categoryList = teamMakerDatabase.getCategoryDao().loadAllCategory();
        playersInSelectedCategory = new HashMap<>();
        if (categoryList == null) {
            return;
        }
        populateMap(teamMakerDatabase.getPlayerDao());

    }

    @Nullable
    public Integer countPlayersWithCategoryId(int categoryId) {
        return 6;
        //return playersInSelectedCategory.get(categoryId);
    }

    private void populateMap(PlayerDao playerDao) {
        for (Category category : categoryList) {
            Integer counted = playerDao.countAllPlayerIdsWithProvidedCategory(category.getId());
            if (counted != null && counted > 0) {
                playersInSelectedCategory.put(category.getId(), counted);
            }
        }
    }

    public boolean addCategory(String categoryName) {
        //false if category exist

        Category category = new Category();
        category.setCategoryName(categoryName);
        //TODO: remove me!
        category.setId(2);
        categoryList.add(category);
        return true;
    }
}
