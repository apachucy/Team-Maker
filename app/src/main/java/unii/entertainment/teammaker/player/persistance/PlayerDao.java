package unii.entertainment.teammaker.player.persistance;


import java.util.List;

import unii.entertainment.teammaker.player.model.Player;

public interface PlayerDao {
    void save(Player player);

    Player loadPlayerById(int playerId);

    Integer countAllPlayerIdsWithProvidedCategory(int catId);

    List<Player> loadAllPlayersFromCategory(int catId);

    void remove(Player player);

    void update(Player player);
}
