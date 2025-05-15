package com.DuongNT.LuyenTap.repository;

import com.DuongNT.LuyenTap.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
