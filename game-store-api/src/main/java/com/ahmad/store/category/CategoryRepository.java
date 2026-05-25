package com.ahmad.store.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, String> {

    // find all categories by name starting with ('ac...
     List<Category> findAllByNameStartingWithIgnoreCaseOrderByNameAsc(String name);

     // JPQL syntax
     @Query("""
            SELECT c FROM Category c 
            WHERE c.name LIKE lower(:catName) 
            ORDER BY c.name ASC 
            """)
     List<Category> findAllByName(@Param("catName") String categoryName);
     

     @NativeQuery(value = "select * from category where name like :catName order by name asc")
     List<Category> findAllByNameUsingNativeQuery(@Param("catName") String categoryName);





}
