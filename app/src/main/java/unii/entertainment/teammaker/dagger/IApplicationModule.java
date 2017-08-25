package unii.entertainment.teammaker.dagger;

import unii.entertainment.teammaker.db.DaoSession;
import unii.entertainment.teammaker.persitence.CategoryConverter;
import unii.entertainment.teammaker.persitence.PlayerConverter;
import unii.entertainment.teammaker.persitence.TeamMakerDatabase;

interface IApplicationModule {

    DaoSession provideDaoSession();

    PlayerConverter providePlayerConverter();

    CategoryConverter provideCategoryConverter();

    TeamMakerDatabase provideApplicationDatabase();
}

