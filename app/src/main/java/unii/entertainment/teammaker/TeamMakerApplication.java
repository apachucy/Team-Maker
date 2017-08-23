package unii.entertainment.teammaker;


import android.app.Application;


public class TeamMakerApplication extends Application  {

    @Override
    public void onCreate() {
        super.onCreate();
       // mComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this, this)).build();
    }


}

