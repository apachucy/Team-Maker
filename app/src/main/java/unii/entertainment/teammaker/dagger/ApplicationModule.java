package unii.entertainment.teammaker.dagger;


import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import unii.entertainment.teammaker.persitence.TeamMakerDatabase;

@Module
public class ApplicationModule implements IApplicationModule {

    private final Context mContext;
    private final HasComponent<ApplicationComponent> mHasApplicationComponent;


    public ApplicationModule(Context context, HasComponent<ApplicationComponent> applicationComponent) {
        mContext = context;
        this.mHasApplicationComponent = applicationComponent;
    }

    @Override
    @Provides
    @Singleton
    public TeamMakerDatabase provideDatabase() {
        return Room.databaseBuilder(mContext.getApplicationContext(), TeamMakerDatabase.class, "team_maker_db")
                .build();
    }


}
