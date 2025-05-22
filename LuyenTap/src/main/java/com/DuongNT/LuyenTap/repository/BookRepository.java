package com.DuongNT.LuyenTap.repository;

import com.DuongNT.LuyenTap.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("SELECT b FROM Book b WHERE b.active = true")
    List<Book> findAllByActive();

    @Query("SELECT c FROM Book c WHERE c.active = true and c.id = :id")
    Optional<Book> findById(@Param("id") int id);
}
