package unii.entertainment.teammaker.persitence;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import unii.entertainment.teammaker.category.model.Category;
import unii.entertainment.teammaker.dagger.ApplicationComponent;
import unii.entertainment.teammaker.db.DaoSession;
import unii.entertainment.teammaker.player.model.Player;

public class TeamMakerDatabase implements Database {
    private static final int AT_LEAST_TWO_PLAYERS = 2;

    @Inject
    DaoSession daoSession;
    private PlayerConverter playerConverter;
    private CategoryConverter categoryConverter;

    public TeamMakerDatabase(ApplicationComponent component, PlayerConverter playerConverter, CategoryConverter categoryConverter) {
        component.inject(this);
        this.playerConverter = playerConverter;
        this.categoryConverter = categoryConverter;
    }

    @Override
    public Player getPlayer(Long playerId) {
        unii.entertainment.teammaker.db.Player dbPlayer = daoSession.getPlayerDao().load(playerId);
        Player modelPlayer = playerConverter.convertToModel(dbPlayer);
        return modelPlayer;
    }

    @Override
    public List<Player> getPlayerInCategory(Long categoryId) {
        unii.entertainment.teammaker.db.Category dbCategory = daoSession.getCategoryDao().load(categoryId);
        List<unii.entertainment.teammaker.db.Player> dbPlayerList = dbCategory.getPlayers();
        List<Player> modelPlayerList = new ArrayList<>();

        for (unii.entertainment.teammaker.db.Player singlePlayer : dbPlayerList) {
            modelPlayerList.add(playerConverter.convertToModel(singlePlayer));
        }

        return modelPlayerList;
    }

    @Override
    public List<Category> getAllCategories() {
        List<unii.entertainment.teammaker.db.Category> dbCategoryList = daoSession.getCategoryDao().loadAll();
        List<Category> modelCategoryList = new ArrayList<>();

        for (unii.entertainment.teammaker.db.Category singleCategory : dbCategoryList) {
            modelCategoryList.add(categoryConverter.convertToModel(singleCategory));
        }
        return modelCategoryList;
    }

    @Override
    public Category getCategory(Long categoryId) {
        unii.entertainment.teammaker.db.Category dbCategory = daoSession.getCategoryDao().load(categoryId);
        Category modelCategory = categoryConverter.convertToModel(dbCategory);
        return modelCategory;
    }

    @Override
    public Category getCategoryForSelectedPlayer(Long playerId) {
        unii.entertainment.teammaker.db.Player dbPlayer = daoSession.getPlayerDao().load(playerId);
        unii.entertainment.teammaker.db.Category dbCategory = dbPlayer.getCategory();
        Category modelCategory = categoryConverter.convertToModel(dbCategory);
        return modelCategory;
    }

    @Override
    public boolean isPlayerExistForCategory(Long categoryId, String playerName) {
        unii.entertainment.teammaker.db.Category dbCategory = daoSession.getCategoryDao().load(categoryId);
        List<unii.entertainment.teammaker.db.Player> dbPlayerList = dbCategory.getPlayers();
        return isPlayerExist(playerName, dbPlayerList);
    }

    @Override
    public boolean isCategoryExist(String categoryName) {
        List<unii.entertainment.teammaker.db.Category> dbCategoryList = daoSession.getCategoryDao().loadAll();
        return isCategoryExist(categoryName, dbCategoryList);
    }

    @Override
    public void saveCategory(Category category) {
        unii.entertainment.teammaker.db.Category dbCategory = categoryConverter.convertToPersistence(category);
        daoSession.getCategoryDao().insert(dbCategory);
    }

    @Override
    public void savePlayer(Long categoryId, Player player) {
        unii.entertainment.teammaker.db.Player dbPlayer = playerConverter.convertToPersistence(player);
        dbPlayer.setCategoryId(categoryId);
        daoSession.getPlayerDao().save(dbPlayer);
    }

    @Override
    public void deletePlayer(Player player) {
        unii.entertainment.teammaker.db.Player dbPlayer = playerConverter.convertToPersistence(player);
        daoSession.getPlayerDao().delete(dbPlayer);
    }

    @Override
    public void deleteCategory(Category category) {
        unii.entertainment.teammaker.db.Category dbCategory = categoryConverter.convertToPersistence(category);
        List<unii.entertainment.teammaker.db.Player> dbPlayerList = dbCategory.getPlayers();

        for (unii.entertainment.teammaker.db.Player dbPlayer : dbPlayerList) {
            daoSession.getPlayerDao().delete(dbPlayer);
        }
        daoSession.getCategoryDao().delete(dbCategory);
    }

    @Override
    public List<Category> getAllCategoriesWithPlayers() {
        List<unii.entertainment.teammaker.db.Category> dbCategoryList = daoSession.getCategoryDao().loadAll();
        List<Category> modelCategoryList = new ArrayList<>();

        for (unii.entertainment.teammaker.db.Category singleCategory : dbCategoryList) {
            if (singleCategory.getPlayers() != null && singleCategory.getPlayers().size() >= AT_LEAST_TWO_PLAYERS) {
                modelCategoryList.add(categoryConverter.convertToModel(singleCategory));
            }
        }

        return modelCategoryList;
    }

    private boolean isPlayerExist(String playerName, List<unii.entertainment.teammaker.db.Player> playerList) {
        for (unii.entertainment.teammaker.db.Player dbPlayer : playerList) {
            if (dbPlayer.getNickName().equals(playerName)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCategoryExist(String categoryName, List<unii.entertainment.teammaker.db.Category> categoryList) {
        for (unii.entertainment.teammaker.db.Category dbCategory : categoryList) {
            if (dbCategory.getCategoryName().equals(categoryName)) {
                return true;
            }
        }
        return false;
    }
}
