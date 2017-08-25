package unii.entertainment.teammaker.dagger;


import javax.inject.Singleton;

import dagger.Component;
import unii.entertainment.teammaker.db.DaoSession;
import unii.entertainment.teammaker.persitence.CategoryConverter;
import unii.entertainment.teammaker.persitence.PlayerConverter;
import unii.entertainment.teammaker.persitence.TeamMakerDatabase;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    ActivityComponent plus(ActivityModule activityModule);

    void inject(DaoSession daoSession);

    void inject(CategoryConverter categoryConverter);

    void inject(PlayerConverter playerConverter);

    void inject(TeamMakerDatabase teamMakerDatabase);
}

