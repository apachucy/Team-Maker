package unii.entertainment.teammaker.player.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import unii.entertainment.teammaker.R;
import unii.entertainment.teammaker.base.BaseActivity;
import unii.entertainment.teammaker.dagger.ActivityComponent;

public class PlayerActivity extends BaseActivity {

    public static String BUNDLE_CATEGORY_ID = "category_id";
    private static final String TAG = PlayerFragment.class.getName().toString();

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ButterKnife.bind(this);

        initToolBar();
        Long categoryId = getIntent().getLongExtra(PlayerActivity.BUNDLE_CATEGORY_ID, 0);

        Fragment playerFragment = new PlayerFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(PlayerActivity.BUNDLE_CATEGORY_ID, categoryId);
        playerFragment.setArguments(bundle);

        replaceFragments(playerFragment, TAG, R.id.content_frame);
    }

    @Override
    protected void injectDependencies(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void initToolBar() {
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setLogoDescription(R.string.app_name);
        toolbar.setTitleTextColor(getResources().getColor(R.color.color_toolbar_text));
        toolbar.setTitle(R.string.app_name);
    }
}
