package unii.entertainment.teammaker.wizard.viewmodel;


import unii.entertainment.teammaker.base.BaseViewModel;
import unii.entertainment.teammaker.category.model.Category;
import unii.entertainment.teammaker.dagger.ActivityComponent;

public class WizardViewModel extends BaseViewModel {
    //TODO: get All categories from db
    private Category selectedCategory;
    private int numberOfTeams;
    private boolean createMixedTeams;

    public WizardViewModel(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    public Category getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(Category selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    public boolean isCreateMixedTeams() {
        return createMixedTeams;
    }

    public void setCreateMixedTeams(boolean createMixedTeams) {
        this.createMixedTeams = createMixedTeams;
    }
}
