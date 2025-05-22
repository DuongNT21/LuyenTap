package com.DuongNT.LuyenTap.controller;

import com.DuongNT.LuyenTap.dto.request.CreateBookRequest;
import com.DuongNT.LuyenTap.dto.response.BaseResponse;
import com.DuongNT.LuyenTap.dto.response.CreateBookResponse;
import com.DuongNT.LuyenTap.dto.response.GetBookResponse;
import com.DuongNT.LuyenTap.service.impl.BookService;
import com.DuongNT.LuyenTap.service.interfaces.IBookService;
import jakarta.persistence.ManyToOne;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final IBookService bookService;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse> createBook(@RequestBody CreateBookRequest request){
        CreateBookResponse response = bookService.createBook(request);
        return ResponseEntity.ok(
                new BaseResponse(
                        "200",
                        "Create book",
                        response
                )
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BaseResponse> getBookById(@PathVariable int id){
        GetBookResponse response = bookService.getBookById(id);
        return ResponseEntity.ok(
                new BaseResponse(
                        "200",
                        "Get book",
                        response
                )
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BaseResponse> updateBook(@PathVariable int id,@RequestBody CreateBookRequest request){
        GetBookResponse response = bookService.updateBook(id, request);
        return ResponseEntity.ok(
                new BaseResponse(
                        "200",
                        "Update book",
                        response
                )
        );
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body(new BaseResponse("404", "Không tìm thấy", null));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BaseResponse> deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
        return ResponseEntity.ok(
                new BaseResponse(
                        "200",
                        "Delete book",
                        null
                )
        );
    }

    @GetMapping("/get")
    public ResponseEntity<BaseResponse> getAllBook(){
        List<GetBookResponse> books = bookService.getAllBook();
        return ResponseEntity.ok(
                new BaseResponse(
                        "200",
                        "Get all book",
                        books
                )
        );
    }
}
