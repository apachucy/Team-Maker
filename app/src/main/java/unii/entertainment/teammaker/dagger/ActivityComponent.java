package unii.entertainment.teammaker.dagger;


import dagger.Subcomponent;
import unii.entertainment.teammaker.CategoryListActivity;
import unii.entertainment.teammaker.category.viewmodel.CategoryListViewModel;

@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(CategoryListActivity mainActivity);

    void inject (CategoryListViewModel viewModel);
}


