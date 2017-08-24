package unii.entertainment.teammaker.category.viewmodel;


import unii.entertainment.teammaker.base.BaseViewModel;
import unii.entertainment.teammaker.category.model.Category;

public class GroupViewModel extends BaseViewModel {
    private Category category;

    //TODO: dodać opcję jeżeli kategoria jest nullem - stwórz ją !
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
