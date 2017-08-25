package unii.entertainment.teammaker.persitence;


import java.util.List;

import unii.entertainment.teammaker.category.model.Category;
import unii.entertainment.teammaker.player.model.Player;

public interface Database {

    Player getPlayer(int playerId);

    List<Player> getPlayerInCategory(int categoryId);

    List<Category> getAllCategories();

    Category getCategory(int categoryId);

    Category getCategoryForSelectedPlayer(int playerId);

    boolean isPlayerExistForCategory(int categoryId, String playerName);

    boolean isCategoryExist(String categoryName);

    void saveCategory(Category category);

    void savePlayer(int categoryId, Player player);

    void deletePlayer(Player player);

    void deleteCategory(Category category);
}
