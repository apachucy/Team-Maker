package unii.entertainment.teammaker.player.model;


public class Player {
    /**
     * Id needs to be public :(
     */
    public int id;
    private int categoryId;

    private Gender gender;
    private int advancementLevel;
    private String nickName;

    public Gender getGender() {
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

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
