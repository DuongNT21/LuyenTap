package com.DuongNT.LuyenTap.repository;

import com.DuongNT.LuyenTap.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT c FROM Category c WHERE c.active = true")
    List<Category> findAllByActive();

    @Query("SELECT c FROM Category c WHERE c.active = true and c.id = :id")
    Optional<Category> findById(@Param("id") int id);
}
