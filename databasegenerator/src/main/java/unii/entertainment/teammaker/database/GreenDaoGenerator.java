package unii.entertainment.teammaker.database;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Property;
import org.greenrobot.greendao.generator.Schema;
import org.greenrobot.greendao.generator.ToMany;

public class GreenDaoGenerator {
    public static final String DATABASE_PACKAGE = "unii.entertainment.teammaker.db";
    public static final int DATABASE_VERSION = 1;

    public static void main(String[] args) {
        Schema schema = new Schema(DATABASE_VERSION, DATABASE_PACKAGE);
        schema.enableKeepSectionsByDefault();

        addTables(schema);
        try {
            new DaoGenerator().generateAll(schema, "./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTables(final Schema schema) {
        Entity category = schema.addEntity("Category");
        category.addIdProperty().primaryKey().autoincrement();
        category.addStringProperty("categoryName").notNull().unique();

        Entity player = schema.addEntity("Player");
        player.addIdProperty().primaryKey().autoincrement();
        player.addStringProperty("nickName").notNull();
        player.addIntProperty("gameLevel").notNull();
        player.addIntProperty("gender").notNull();

        Property categoryId = player.addLongProperty("categoryId").getProperty();
        player.addToOne(category, categoryId);
        ToMany playerToCategory = category.addToMany(player, categoryId);
        playerToCategory.setName("players");
    }


}
