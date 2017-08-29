package unii.entertainment.teammaker;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import unii.entertainment.teammaker.base.BaseActivity;
import unii.entertainment.teammaker.category.view.CategoryFragment;
import unii.entertainment.teammaker.dagger.ActivityComponent;

public class CategoryListActivity extends BaseActivity {

    private static final String TAG_FRAGMENT_CATEGORY_LIST = CategoryListActivity.class
            .getName() + "TAG_FRAGMENT_CATEGORY_LIST";

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ButterKnife.bind(this);
        initToolBar();
        replaceFragments(new CategoryFragment(), TAG_FRAGMENT_CATEGORY_LIST, R.id.content_frame);
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
