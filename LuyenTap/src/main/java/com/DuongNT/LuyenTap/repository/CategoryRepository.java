package com.DuongNT.LuyenTap.repository;

import com.DuongNT.LuyenTap.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT c FROM Category c WHERE c.active = true")
    List<Category> findAllByActive();
}
