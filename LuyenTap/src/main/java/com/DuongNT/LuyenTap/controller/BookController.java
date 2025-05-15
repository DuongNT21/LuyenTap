package com.DuongNT.LuyenTap.controller;

import com.DuongNT.LuyenTap.dto.request.CreateBookRequest;
import com.DuongNT.LuyenTap.dto.response.CreateBookResponse;
import com.DuongNT.LuyenTap.dto.response.GetBookResponse;
import com.DuongNT.LuyenTap.service.impl.BookService;
import com.DuongNT.LuyenTap.service.interfaces.IBookService;
import jakarta.persistence.ManyToOne;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final IBookService bookService;

    @PostMapping("/create")
    public CreateBookResponse createBook(@RequestBody CreateBookRequest request){
        return bookService.createBook(request);
    }

    @GetMapping("/get/{id}")
    public GetBookResponse getBookById(@PathVariable int id){
        return bookService.getBookById(id);
    }

    @PutMapping("/update/{id}")
    public GetBookResponse updateBook(@PathVariable int id,@RequestBody CreateBookRequest request){
        return bookService.updateBook(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
    }

    @GetMapping("/get")
    public List<GetBookResponse> getAllBook(){
        return bookService.getAllBook();
    }
}
