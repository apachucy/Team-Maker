package unii.entertainment.teammaker.player.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import unii.entertainment.teammaker.R;
import unii.entertainment.teammaker.base.BaseActivity;
import unii.entertainment.teammaker.dagger.ActivityComponent;

public class PlayerActivity extends BaseActivity {

    public static String BUNDLE_CATEGORY_ID = "category_id";

    private static final String TAG = PlayerFragment.class.getName().toString();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Long categoryId = getIntent().getLongExtra(PlayerActivity.BUNDLE_CATEGORY_ID, 0);

        Fragment playerFragment = new PlayerFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(PlayerActivity.BUNDLE_CATEGORY_ID, categoryId);
        playerFragment.setArguments(bundle);

        replaceFragments(playerFragment, TAG, R.id.fragment_container);
    }

    @Override
    protected void injectDependencies(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }
}
