package unii.entertainment.teammaker.category.viewmodel;


import android.arch.lifecycle.LiveData;
import android.support.annotation.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import unii.entertainment.teammaker.base.viewmodel.BaseViewModel;
import unii.entertainment.teammaker.category.model.Category;
import unii.entertainment.teammaker.persitence.TeamMakerDatabase;
import unii.entertainment.teammaker.player.persistance.PlayerDao;

public class CategoryListViewModel extends BaseViewModel {

    private LiveData<List<Category>> categoryList;
    private Map<Integer, Integer> playersInSelectedCategory;

    public LiveData<List<Category>> getCategoryList() {
        return categoryList;
    }

    public CategoryListViewModel(TeamMakerDatabase teamMakerDatabase) {
        categoryList = teamMakerDatabase.getCategoryDao().loadAllCategory();
        playersInSelectedCategory = new HashMap<>();
        if (categoryList.getValue() == null) {
            return;
        }
        populateMap(teamMakerDatabase.getPlayerDao());

    }

    @Nullable
    public Integer getPlayersWithId(int categoryId) {
        return playersInSelectedCategory.get(categoryId);
    }

    private void populateMap(PlayerDao playerDao) {
        for (Category category : categoryList.getValue()) {
            Integer counted = playerDao.countAllPlayerIdsWithProvidedCategory(category.getId());
            if (counted != null && counted > 0) {
                playersInSelectedCategory.put(category.getId(), counted);
            }
        }
    }
}
