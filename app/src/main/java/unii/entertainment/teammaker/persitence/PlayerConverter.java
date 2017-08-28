package unii.entertainment.teammaker.persitence;

import unii.entertainment.teammaker.player.model.Gender;
import unii.entertainment.teammaker.player.model.Player;
import unii.entertainment.teammaker.repository.Converter;

import static unii.entertainment.teammaker.player.model.Gender.FEMALE;
import static unii.entertainment.teammaker.player.model.Gender.MALE;

public class PlayerConverter implements Converter<Player, unii.entertainment.teammaker.db.Player> {
    private static final int MALE_VALUE = 1;
    private static final int FEMALE_VALUE = 0;

    public PlayerConverter() {
    }

    @Override
    public Player convertToModel(unii.entertainment.teammaker.db.Player object) {
        Player player = new Player();
        player.setAdvancementLevel(object.getGameLevel());
        player.setNickName(object.getNickName());
        player.setGender(intToGender(object.getGender()));
        if (!object.getCategoryId().equals(Player.EMPTY_ID)) {
            player.setCategoryId(object.getCategoryId());
        }
        if (!object.getId().equals(Player.EMPTY_ID)) {
            player.setId(object.getId());
        }
        return player;
    }

    @Override
    public unii.entertainment.teammaker.db.Player convertToPersistence(Player object) {
        unii.entertainment.teammaker.db.Player player = new unii.entertainment.teammaker.db.Player();
        player.setNickName(object.getNickName());
        player.setGameLevel(object.getAdvancementLevel());
        player.setGender(genderToInt(object.getGender()));
        if (!object.getCategoryId().equals(Player.EMPTY_ID)) {
            player.setCategoryId(object.getCategoryId());
        }
        if (!object.getId().equals(Player.EMPTY_ID)) {
            player.setId(object.getId());
        }

        return player;
    }


    private int genderToInt(Gender gender) {
        switch (gender) {
            case MALE:
                return MALE_VALUE;
            case FEMALE:
                return FEMALE_VALUE;
            default:
                return MALE_VALUE;
        }
    }

    private Gender intToGender(int genderValue) {
        switch (genderValue) {
            case MALE_VALUE:
                return MALE;
            case FEMALE_VALUE:
                return FEMALE;
            default:
                return MALE;
        }
    }
}
