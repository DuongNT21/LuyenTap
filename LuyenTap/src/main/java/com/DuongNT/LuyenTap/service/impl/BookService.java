package com.DuongNT.LuyenTap.service.impl;

import com.DuongNT.LuyenTap.dto.request.CreateBookRequest;
import com.DuongNT.LuyenTap.dto.response.BaseResponse;
import com.DuongNT.LuyenTap.dto.response.CreateBookResponse;
import com.DuongNT.LuyenTap.dto.response.GetBookResponse;
import com.DuongNT.LuyenTap.entity.Book;
import com.DuongNT.LuyenTap.entity.Category;
import com.DuongNT.LuyenTap.repository.BookRepository;
import com.DuongNT.LuyenTap.repository.CategoryRepository;
import com.DuongNT.LuyenTap.service.interfaces.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class BookService implements IBookService {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public CreateBookResponse createBook(CreateBookRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId()).orElse(null);
        Book book = new Book();

        book.setName(request.getName());
        book.setAuthor(request.getAuthor());
        book.setCreatedAt(LocalDateTime.now());
        book.setPrice(request.getPrice());
        book.setCategory(category);
        bookRepository.save(book);

        CreateBookResponse response = new CreateBookResponse();
        response.setName(book.getName());
        response.setAuthor(book.getAuthor());
        response.setCreatedAt(book.getCreatedAt());
        response.setId(book.getId());
        response.setCategoryId(book.getCategory().getId());
        return response;
    }

    @Override
    public void deleteBook(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        book.setActive(false);
        System.out.println();
        bookRepository.save(book);
    }

    @Override
    public GetBookResponse getBookById(int id) {
        BaseResponse baseResponse = new BaseResponse();
        Book book = new Book();
        try {
             book = bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book not found"));
        } catch (Exception e) {
            throw new RuntimeException("Book not found");
        }
        GetBookResponse response = new GetBookResponse();
        response.setName(book.getName());
        response.setAuthor(book.getAuthor());
        response.setCreatedAt(book.getCreatedAt());
        response.setId(book.getId());
        response.setCategoryId(book.getCategory().getId());
        return response;
    }

    @Override
    public GetBookResponse updateBook(int id, CreateBookRequest request) {
        Book book = bookRepository.findById(id).orElse(null);
        Category category = categoryRepository.findById(request.getCategoryId()).orElse(null);
        book.setName(request.getName() == null ? book.getName() : request.getName());
        book.setAuthor(request.getAuthor() == null ? book.getAuthor() : request.getAuthor());
        book.setPrice(request.getPrice() == 0 ? book.getPrice() : request.getPrice());
        book.setCategory(request.getCategoryId() == 0 ? book.getCategory() : category);
        bookRepository.save(book);
        GetBookResponse response = new GetBookResponse();
        response.setId(book.getId());
        response.setName(book.getName());
        response.setAuthor(book.getAuthor());
        response.setPrice(book.getPrice());
        response.setCategoryId(book.getCategory().getId());
        return response;
    }

    @Override
    public List<GetBookResponse> getAllBook() {
        List<Book> books = bookRepository.findAllByActive();
        List<GetBookResponse> responses = new ArrayList<>();
        for (Book book : books) {
            GetBookResponse item = new GetBookResponse();
            item.setName(book.getName());
            item.setAuthor(book.getAuthor());
            item.setCreatedAt(book.getCreatedAt());
            item.setId(book.getId());
            item.setCategoryId(book.getCategory().getId());
            responses.add(item);
        }
        return responses;
    }

    @Override
    public List<GetBookResponse> getBookByCategoryId(int id) {
        List<Book> books = bookRepository.findAll();
        List<GetBookResponse> responses = new ArrayList<>();
        for (Book book : books) {
            if (book.getCategory().getId() == id) {
                GetBookResponse response = new GetBookResponse();
                response.setName(book.getName());
                response.setAuthor(book.getAuthor());
                response.setCreatedAt(book.getCreatedAt());
                response.setId(book.getId());
                response.setCategoryId(book.getCategory().getId());
                responses.add(response);
            }
        }
        return responses;
    }
}
