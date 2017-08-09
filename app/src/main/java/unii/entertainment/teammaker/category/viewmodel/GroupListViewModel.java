package unii.entertainment.teammaker.category.viewmodel;


import android.arch.lifecycle.LiveData;

import java.util.List;

import unii.entertainment.teammaker.base.viewmodel.BaseViewModel;
import unii.entertainment.teammaker.category.model.Category;

public class GroupListViewModel extends BaseViewModel {

    private LiveData<List<Category>> categoryList;

    public LiveData<List<Category>> getCategoryList() {
        return categoryList;
    }
/*
    public GroupListViewModel(ActivityComponent component) {
        component.inject(this);
        //    categoryList =
    }
*/
    public void setCategoryList(LiveData<List<Category>> categoryList) {
        this.categoryList = categoryList;
    }


}
