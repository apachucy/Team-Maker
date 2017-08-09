package unii.entertainment.teammaker.category.viewmodel;


import android.arch.lifecycle.LiveData;

import unii.entertainment.teammaker.base.viewmodel.BaseViewModel;
import unii.entertainment.teammaker.category.model.Category;

public class GroupViewModel extends BaseViewModel {
    private LiveData<Category> category;
//TODO: dodać opcję jeżeli kategoria jest nullem - stwórz ją !
    public LiveData<Category> getCategory() {
        return category;
    }

    public void setCategory(LiveData<Category> category) {
        this.category = category;
    }


}
