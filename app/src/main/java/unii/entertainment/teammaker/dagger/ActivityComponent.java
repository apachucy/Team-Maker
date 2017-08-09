package unii.entertainment.teammaker.dagger;


import dagger.Subcomponent;
import unii.entertainment.teammaker.CategoryListActivity;
import unii.entertainment.teammaker.category.viewmodel.GroupListViewModel;

@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(CategoryListActivity mainActivity);

    void inject (GroupListViewModel viewModel);
}


