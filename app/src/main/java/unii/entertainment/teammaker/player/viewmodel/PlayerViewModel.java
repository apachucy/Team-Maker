package unii.entertainment.teammaker.player.viewmodel;


import javax.inject.Inject;

import unii.entertainment.teammaker.R;
import unii.entertainment.teammaker.base.BaseViewModel;
import unii.entertainment.teammaker.dagger.ActivityComponent;
import unii.entertainment.teammaker.persitence.TeamMakerDatabase;
import unii.entertainment.teammaker.player.model.Gender;
import unii.entertainment.teammaker.player.model.Player;

public class PlayerViewModel extends BaseViewModel {
    private Long categoryId;
    @Inject
    TeamMakerDatabase teamMakerDatabase;

    public PlayerViewModel(ActivityComponent component, Long categoryId) {
        component.inject(this);
        this.categoryId = categoryId;
    }

    public boolean isPlayerExistForCategory(String playerName) {
        return teamMakerDatabase.isPlayerExistForCategory(categoryId, playerName);
    }

    public void addPlayer(String playerName, int gender, int gameLevel) {

        Player player = new Player();
        player.setNickName(playerName);
        Gender sex = convertGender(gender);
        player.setGender(sex);
        player.setAdvancementLevel(gameLevel);
        //if not save a player to local db
        teamMakerDatabase.savePlayer(categoryId, player);
    }


    private Gender convertGender(int gender) {
        switch (gender) {
            case R.id.female_radio:
                return Gender.FEMALE;
            case R.id.male_radio:
                return Gender.MALE;
            default:
                return Gender.MALE;
        }
    }
}
