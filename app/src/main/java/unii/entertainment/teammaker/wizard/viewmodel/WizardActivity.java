package unii.entertainment.teammaker.wizard.viewmodel;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import unii.entertainment.teammaker.R;
import unii.entertainment.teammaker.base.BaseActivity;
import unii.entertainment.teammaker.dagger.ActivityComponent;
import unii.entertainment.teammaker.wizard.view.CategoryWizardFragment;
import unii.entertainment.teammaker.wizard.view.SelectPlayersWizardFragment;

public class WizardActivity extends BaseActivity {


    private PagerAdapter mPagerAdapter;


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tabDots)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ButterKnife.bind(this);
        initToolBar();
        initData();
        initView();
    }

    @Override
    protected void injectDependencies(ActivityComponent activityComponent) {

    }

    @Override
    protected void initToolBar() {
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setLogoDescription(R.string.app_name);
        toolbar.setTitleTextColor(getResources().getColor(R.color.color_toolbar_text));
        toolbar.setTitle(R.string.app_name);
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    private void initView() {
        viewPager.setAdapter(mPagerAdapter);
        tabLayout.setupWithViewPager(viewPager, true);
    }

    private void initData() {
        mPagerAdapter = new WizardPageAdapter(getSupportFragmentManager());
    }

    private class WizardPageAdapter extends FragmentStatePagerAdapter {
        private static final int NUM_PAGES = 3;

        public WizardPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 1:
                    return new CategoryWizardFragment();
                case 2:
                    return new SelectPlayersWizardFragment();
                default:
                    return new CategoryWizardFragment();
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

}
