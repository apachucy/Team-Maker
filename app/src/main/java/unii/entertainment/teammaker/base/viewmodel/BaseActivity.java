package unii.entertainment.teammaker.base.viewmodel;

import android.support.v7.app.AppCompatActivity;


public abstract class BaseActivity extends AppCompatActivity  {
 /*   private ActivityComponent mActivityComponent;

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
*/
}
