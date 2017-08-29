package unii.entertainment.teammaker.category.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import unii.entertainment.teammaker.R;
import unii.entertainment.teammaker.base.BaseFragment;
import unii.entertainment.teammaker.category.adapter.CategoryListAdapter;
import unii.entertainment.teammaker.category.viewmodel.CategoryListViewModel;
import unii.entertainment.teammaker.dagger.ActivityComponent;
import unii.entertainment.teammaker.wizzard.viewmodel.WizardActivity;

public class CategoryFragment extends BaseFragment {
    private CategoryListViewModel viewModel;
    private RecyclerView.Adapter categoryAdapter;
    private View root;

    @BindView(R.id.list_view)
    RecyclerView listView;
    @BindView(R.id.empty_text)
    TextView emptyView;

    @BindView(R.id.edit_action_button)
    FloatingActionButton actionButton;


    @OnClick(R.id.create_teams_action_button)
    public void onTeamGenerateActionButtonClicked(View v) {
        if (viewModel.categoryWithPlayersExist()) {
            Intent intent = new Intent(getContext(), WizardActivity.class);
            startActivity(intent);
            return;
        }
        showInformationSnackBar(root,getString(R.string.warning_category_add_more_persons), Snackbar.LENGTH_SHORT);
    }

    @OnClick(R.id.edit_action_button)
    public void onEditActionButtonClicked(View v) {
        new MaterialDialog.Builder(getContext())
                .title(R.string.dialog_add_category_title)
                .content(R.string.dialog_add_category_body)
                .input(R.string.dialog_add_category_hint, R.string.dialog_prefill, (dialog, input) -> {
                    // Do something
                    if (input == null || input.length() == 0) {
                        showInformationSnackBar(root, getString(R.string.warning_category_name_not_provided), Snackbar.LENGTH_SHORT);
                        return;
                    }

                    String categoryName = input.toString();

                    if (viewModel.categoryExist(categoryName)) {
                        showInformationSnackBar(root, getString(R.string.category_exist_warning), Snackbar.LENGTH_SHORT);
                        return;
                    }
                    boolean success = viewModel.addCategory(categoryName);
                    if (success) {
                        showList();
                        categoryAdapter.notifyDataSetChanged();
                    }
                }).show();
    }


    private void showList() {
        listView.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
    }

    private void hideList() {
        listView.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this, view);
        root = view;
        injectDependencies();
        initData(getActivityComponent());
        initView();
        return view;
    }

    @Override
    protected void injectDependencies() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initView() {
        if (viewModel.getCategoryList() == null || viewModel.getCategoryList().isEmpty()) {
            hideList();
        } else {
            showList();
        }
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        listView.setLayoutManager(mLayoutManager);
        listView.setItemAnimator(new DefaultItemAnimator());
        listView.setAdapter(categoryAdapter);
    }

    @Override
    protected void initData(ActivityComponent component) {
        viewModel = new CategoryListViewModel(component);
        categoryAdapter = new CategoryListAdapter(viewModel);
    }

    @Override
    public void onResume() {
        super.onResume();
        //TODO: improve me - nie dzierga
        categoryAdapter.notifyDataSetChanged();
    }
}
