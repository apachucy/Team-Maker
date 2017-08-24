package unii.entertainment.teammaker.category.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
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
import unii.entertainment.teammaker.category.model.Category;
import unii.entertainment.teammaker.category.viewmodel.CategoryListViewModel;
import unii.entertainment.teammaker.persitence.TeamMakerDatabase;

public class CategoryFragment extends BaseFragment {
    private CategoryListViewModel viewModel;
    private RecyclerView.Adapter categoryAdapter;

    // @Inject
    TeamMakerDatabase teamMakerDatabase;


    @BindView(R.id.list_view)
    RecyclerView listView;
    @BindView(R.id.empty_text)
    TextView emptyView;

    @BindView(R.id.action_button)
    FloatingActionButton actionButton;

    @OnClick(R.id.action_button)
    public void onActionButtonClicked(View v) {
        new MaterialDialog.Builder(getContext())
                .title(R.string.dialog_add_category_title)
                .content(R.string.dialog_add_category_body)
                .input(R.string.dialog_add_category_hint, R.string.dialog_prefill, (dialog, input) -> {
                    // Do something
                    if (input == null || input.length() == 0) {
                        //Display text with information about empty String!
                        return;
                    }
                    String categoryName = (String) input;
                    Category category = new Category();
                    category.setCategoryName(categoryName);
                    //     teamMakerDatabase.getCategoryDao().save(category);
                }).show();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


       /* viewModel.getCategory().observe(this, category -> {
            //Update UI ?
        });*/
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
    //    injectDependencies();

        // viewModel.init(teamMakerDatabase);
        if (viewModel.getCategoryList() == null || viewModel.getCategoryList().isEmpty()) {
            hideList();
        } else {
            showList();
            categoryAdapter = new CategoryListAdapter(viewModel);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            listView.setLayoutManager(mLayoutManager);
            listView.setItemAnimator(new DefaultItemAnimator());
            listView.setAdapter(categoryAdapter);

        }
        return view;
    }

 /*   @Override
    protected void injectDependencies() {
        getActivityComponent().inject(this);
    }*/
}
