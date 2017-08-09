package unii.entertainment.teammaker.dagger;



import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    ActivityComponent plus(ActivityModule activityModule);

}

