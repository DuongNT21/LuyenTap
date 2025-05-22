package com.DuongNT.LuyenTap.service.interfaces;

import com.DuongNT.LuyenTap.dto.request.CreateBookRequest;
import com.DuongNT.LuyenTap.dto.response.BaseResponse;
import com.DuongNT.LuyenTap.dto.response.CreateBookResponse;
import com.DuongNT.LuyenTap.dto.response.GetBookResponse;

import java.util.List;

public interface IBookService {
    CreateBookResponse createBook(CreateBookRequest request);
    void deleteBook(int id);
    GetBookResponse getBookById(int id);
    GetBookResponse updateBook(int id, CreateBookRequest request);
    List<GetBookResponse> getAllBook();
    List<GetBookResponse> getBookByCategoryId(int id);
}
