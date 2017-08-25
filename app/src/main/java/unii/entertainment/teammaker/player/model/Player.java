package unii.entertainment.teammaker.player.model;


public class Player {
    public static final Long EMPTY_ID = -1L;
    private Long id;
    private Long categoryId;

    private Gender gender;
    private int advancementLevel;
    private String nickName;


    public Player() {
        id = EMPTY_ID;
        categoryId = EMPTY_ID;
    }

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


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
