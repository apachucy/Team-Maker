package unii.entertainment.teammaker.player.view;

import android.os.Bundle;

import unii.entertainment.teammaker.R;
import unii.entertainment.teammaker.base.BaseActivity;
import unii.entertainment.teammaker.dagger.ActivityComponent;

public class PlayerActivity extends BaseActivity {

    public static String BUNDLE_CATEGORY_ID = "category_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
    }

    @Override
    protected void injectDependencies(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }
}
