package com.DuongNT.LuyenTap.repository;

import com.DuongNT.LuyenTap.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("SELECT b FROM Book b WHERE b.active = true")
    List<Book> findAllByActive();
}
