package unii.entertainment.teammaker.dagger;


import dagger.Subcomponent;
import unii.entertainment.teammaker.CategoryListActivity;
import unii.entertainment.teammaker.category.view.CategoryFragment;
import unii.entertainment.teammaker.category.viewmodel.CategoryListViewModel;
import unii.entertainment.teammaker.player.view.PlayerActivity;
import unii.entertainment.teammaker.player.view.PlayerFragment;
import unii.entertainment.teammaker.player.viewmodel.PlayerViewModel;
import unii.entertainment.teammaker.wizard.view.CategoryWizardFragment;
import unii.entertainment.teammaker.wizard.viewmodel.WizardViewModel;

@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(CategoryListActivity mainActivity);

    void inject(PlayerActivity playerActivity);

    void inject(CategoryFragment categoryFragment);

    void inject(PlayerFragment playerFragment);

    void inject(CategoryWizardFragment categoryWizardFragment);

    void inject(CategoryListViewModel viewModel);

    void inject(PlayerViewModel playerViewModel);

    void inject(WizardViewModel wizardViewModel);
}


