package unii.entertainment.teammaker.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import unii.entertainment.teammaker.TeamMakerApplication;
import unii.entertainment.teammaker.dagger.ActivityComponent;
import unii.entertainment.teammaker.dagger.ActivityModule;
import unii.entertainment.teammaker.dagger.ApplicationComponent;
import unii.entertainment.teammaker.dagger.HasComponent;


public abstract class BaseActivity extends AppCompatActivity implements HasComponent<ActivityComponent> {
    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityComponent activityComponent = initActivityComponent();
        injectDependencies(activityComponent);
    }

    private ActivityComponent initActivityComponent() {
        TeamMakerApplication application = (TeamMakerApplication) getApplication();
        final ApplicationComponent applicationComponent = application.getComponent();

        mActivityComponent = applicationComponent.plus(new ActivityModule(this, this));
        return mActivityComponent;
    }

    @Override
    public ActivityComponent getComponent() {
        return mActivityComponent;
    }

    protected abstract void injectDependencies(final ActivityComponent activityComponent);

}
