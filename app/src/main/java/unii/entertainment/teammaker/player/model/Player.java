package unii.entertainment.teammaker.player.model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import unii.entertainment.teammaker.category.model.Category;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Category.class,
        parentColumns = "id",
        childColumns = "categoryId",
        onDelete = CASCADE))
//@TypeConverters({GenderConverter.class})

public class Player {
    /**
     * Id needs to be public :(
     */
    @PrimaryKey(autoGenerate = true)
    public int id;
    private int categoryId;

    private String gender;
    private int advancementLevel;
    private String nickName;

    public String getGender() {
        return gender;
    }

    public int getAdvancementLevel() {
        return advancementLevel;
    }

    public void setAdvancementLevel(int advancementLevel) {
        this.advancementLevel = advancementLevel;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
