package unii.entertainment.teammaker.category.view;


import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import unii.entertainment.teammaker.R;
import unii.entertainment.teammaker.category.viewmodel.CategoryListViewModel;

public class GroupListFragment extends LifecycleFragment {
    private CategoryListViewModel viewModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(CategoryListViewModel.class);
        viewModel.getCategoryList().observe(this, categoryList -> {
            //Update UI ?
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.category_list, container, false);
    }
}

