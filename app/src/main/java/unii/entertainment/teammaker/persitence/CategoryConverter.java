package unii.entertainment.teammaker.persitence;

import unii.entertainment.teammaker.category.model.Category;
import unii.entertainment.teammaker.repository.Converter;

public class CategoryConverter implements Converter<Category, unii.entertainment.teammaker.db.Category> {

    public CategoryConverter() {
    }

    @Override
    public Category convertToModel(unii.entertainment.teammaker.db.Category object) {
        Category category = new Category();
        category.setCategoryName(object.getCategoryName());
        if (!object.getId().equals(Category.EMPTY_ID)) {
            category.setId(object.getId());
        }
        if (object.getPlayers().size() != Category.NO_PERSONS) {
            category.setPersonsInCategory(object.getPlayers().size());
        }
        return category;
    }

    @Override
    public unii.entertainment.teammaker.db.Category convertToPersistence(Category object) {
        unii.entertainment.teammaker.db.Category category = new unii.entertainment.teammaker.db.Category();
        category.setCategoryName(object.getCategoryName());
        if (!object.getId().equals(Category.EMPTY_ID)) {
            category.setId(object.getId());
        }
        return category;
    }
}
