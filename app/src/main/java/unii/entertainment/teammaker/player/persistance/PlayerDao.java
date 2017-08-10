package unii.entertainment.teammaker.player.persistance;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import unii.entertainment.teammaker.player.model.Player;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface PlayerDao {
    @Insert(onConflict = REPLACE)
    void save(Player player);

    @Query("SELECT * FROM Player WHERE id = :playerId  LIMIT 1")
    Player loadPlayerById(int playerId);


    @Query("SELECT COUNT (nickName) FROM  Player WHERE categoryId =:catId")
    Integer countAllPlayerIdsWithProvidedCategory(int catId);

    @Query("SELECT * FROM Player WHERE categoryId = :catId")
    List<Player> loadAllPlayersFromCategory(int catId);

    @Delete
    void remove(Player player);

    @Update(onConflict = REPLACE)
    void update(Player player);
}
