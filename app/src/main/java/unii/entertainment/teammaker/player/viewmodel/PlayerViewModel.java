package unii.entertainment.teammaker.player.viewmodel;


import unii.entertainment.teammaker.R;
import unii.entertainment.teammaker.base.BaseViewModel;
import unii.entertainment.teammaker.player.model.Gender;
import unii.entertainment.teammaker.player.model.Player;

public class PlayerViewModel extends BaseViewModel {
    private Player player;


    public boolean checkPlayerName(String playerName) {
        //TODO; check if player exist in db

        return false;
    }

    public boolean addPlayer(String playerName, int gender, int gameLevel) {

        player = new Player();
        player.setNickName(playerName);
        Gender sex = convertGender(gender);
        player.setGender(sex);
        player.setAdvancementLevel(gameLevel);
        //if not save a player to local db
        return true;
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
