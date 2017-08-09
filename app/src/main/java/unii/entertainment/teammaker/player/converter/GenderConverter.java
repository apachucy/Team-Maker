package unii.entertainment.teammaker.player.converter;


import android.arch.persistence.room.TypeConverter;

import unii.entertainment.teammaker.player.model.Gender;

public class GenderConverter {
    //TODO: typeConverters są niedopracowane i nie działają!
    @TypeConverter
    public static Gender stringToGender(String gender) {
        return Gender.valueOf(gender);
    }

    @TypeConverter
    public static String genderToString(Gender gender) {
        return gender.name();
    }
}
