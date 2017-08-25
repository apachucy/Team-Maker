package unii.entertainment.teammaker;


import android.app.Application;

import unii.entertainment.teammaker.dagger.ApplicationComponent;
import unii.entertainment.teammaker.dagger.ApplicationModule;
import unii.entertainment.teammaker.dagger.DaggerApplicationComponent;
import unii.entertainment.teammaker.dagger.HasComponent;


public class TeamMakerApplication extends Application implements HasComponent<ApplicationComponent> {
    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this, this)).build();
    }


    @Override
    public ApplicationComponent getComponent() {
        return mComponent;
    }
}

