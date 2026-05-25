package com.ahmad.store.game;

import com.ahmad.store.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, String> {

    // find all games by category
    List<Game> findAllByCategory(Category category);

    // find all games by category id
    List<Game> findAllByCategoryId(String categoryId);

    List<Game> findAllByCategoryName(String categoryName);

//    @Query("""
//               SELECT g FROM Game g
//               INNER JOIN Category c  ON g.category.id = c.id
//               WHERE c.name Like :catName
//            """)

    @Query("""
            SELECT g FROM Game g
            INNER JOIN g.category c
            WHERE c.name LIKE :catName
            """)
    List<Game> findAllByCat(@Param("catName") String catName);

    @Query("""
            UPDATE Game SET title = upper(title) 
            """
    )
    @Modifying
    void transformGamesTitleToUpperCase();
}
