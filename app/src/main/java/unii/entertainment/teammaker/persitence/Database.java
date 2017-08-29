package unii.entertainment.teammaker.persitence;


import java.util.List;

import unii.entertainment.teammaker.category.model.Category;
import unii.entertainment.teammaker.player.model.Player;

public interface Database {

    Player getPlayer(Long playerId);

    List<Player> getPlayerInCategory(Long categoryId);

    List<Category> getAllCategories();

    Category getCategory(Long categoryId);

    Category getCategoryForSelectedPlayer(Long playerId);

    boolean isPlayerExistForCategory(Long categoryId, String playerName);

    boolean isCategoryExist(String categoryName);

    void saveCategory(Category category);

    void savePlayer(Long categoryId, Player player);

    void deletePlayer(Player player);

    void deleteCategory(Category category);

    List<Category> getAllCategoriesWithPlayers();
}
