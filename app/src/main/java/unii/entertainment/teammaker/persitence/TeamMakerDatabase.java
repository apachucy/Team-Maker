package unii.entertainment.teammaker.persitence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import unii.entertainment.teammaker.category.model.Category;
import unii.entertainment.teammaker.category.persistence.CategoryDao;
import unii.entertainment.teammaker.player.converter.GenderConverter;
import unii.entertainment.teammaker.player.model.Player;
import unii.entertainment.teammaker.player.persistance.PlayerDao;

@Database(entities = {Category.class, Player.class}, version = 1)
//@TypeConverters(GenderConverter.class)

public abstract class TeamMakerDatabase extends RoomDatabase {

    public abstract CategoryDao getCategoryDao();

    public abstract PlayerDao getPlayerDao();
}
