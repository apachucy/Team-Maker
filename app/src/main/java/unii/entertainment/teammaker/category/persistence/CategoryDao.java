package unii.entertainment.teammaker.category.persistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import unii.entertainment.teammaker.category.model.Category;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface CategoryDao {
    @Insert(onConflict = REPLACE)
    void save(Category category);
//TODO: ważne - nie używać słów których używa sql jako nazwy tabeli...
      @Query("SELECT * FROM Category WHERE id = :cId LIMIT 1")//
       public Category loadCategoryById(int cId);

    @Query("SELECT * FROM Category")
    public List<Category> loadAllCategory();

    @Delete
    void remove(Category category);

    @Update(onConflict = REPLACE)
    void update(Category category);
}
