package unii.entertainment.teammaker.dagger;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import unii.entertainment.teammaker.db.DaoMaster;
import unii.entertainment.teammaker.db.DaoSession;
import unii.entertainment.teammaker.persitence.CategoryConverter;
import unii.entertainment.teammaker.persitence.PlayerConverter;
import unii.entertainment.teammaker.persitence.TeamMakerDatabase;

@Module
public class ApplicationModule implements IApplicationModule {
    private final static String DATABASE_NAME = "team_maker.db";
    private final Context context;
    private final HasComponent<ApplicationComponent> hasApplicationComponent;
    private DaoMaster.DevOpenHelper helper;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    public ApplicationModule(Context context, HasComponent<ApplicationComponent> applicationComponent) {
        this.context = context;
        this.hasApplicationComponent = applicationComponent;
    }

    @Override
    @Provides
    @Singleton
    public DaoSession provideDaoSession() {
        //OpenSession
        if (helper == null) {
            helper = new DaoMaster.DevOpenHelper(context, DATABASE_NAME, null);
            db = helper.getWritableDatabase();
            daoMaster = new DaoMaster(db);
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

    @Override
    @Provides
    @Singleton
    public TeamMakerDatabase provideApplicationDatabase() {
        return new TeamMakerDatabase(hasApplicationComponent.getComponent(), new PlayerConverter(), new CategoryConverter());
    }


}
