package unii.entertainment.teammaker;

import android.os.Bundle;

import unii.entertainment.teammaker.base.BaseActivity;

public class CategoryListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
    }

 /*   @Override
    protected void injectDependencies(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }*/
}
