package unii.entertainment.teammaker.persitence;

import unii.entertainment.teammaker.category.persistence.CategoryDao;
import unii.entertainment.teammaker.player.persistance.PlayerDao;

public abstract class TeamMakerDatabase {

    public abstract CategoryDao getCategoryDao();

    public abstract PlayerDao getPlayerDao();
}
