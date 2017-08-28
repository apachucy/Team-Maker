package unii.entertainment.teammaker.dagger;

import unii.entertainment.teammaker.db.DaoSession;
import unii.entertainment.teammaker.persitence.TeamMakerDatabase;

interface IApplicationModule {

    DaoSession provideDaoSession();


    TeamMakerDatabase provideApplicationDatabase();
}

