package unii.entertainment.teammaker.base;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;

import unii.entertainment.teammaker.dagger.ActivityComponent;
import unii.entertainment.teammaker.dagger.HasComponent;


public abstract class BaseFragment extends Fragment {
    private Snackbar actionSnackBar;

    public ActivityComponent getActivityComponent() {
        return ((BaseActivity) getActivity()).getComponent();
    }

    abstract protected void injectDependencies();

    abstract protected void initView();

    abstract protected void initData(ActivityComponent component);


    protected void showActionSnackBar(View view, String title, int timer, String actionName, View.OnClickListener action) {
        actionSnackBar = Snackbar.make(view, title, timer).setAction(actionName, action);
        actionSnackBar.show();
    }

    protected void showInformationSnackBar(View view, String title, int timer) {
        actionSnackBar = Snackbar.make(view, title, timer);
        actionSnackBar.show();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (actionSnackBar != null && actionSnackBar.isShown()) {
            actionSnackBar.dismiss();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (actionSnackBar != null) {
            actionSnackBar.show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        actionSnackBar = null;
    }
}







