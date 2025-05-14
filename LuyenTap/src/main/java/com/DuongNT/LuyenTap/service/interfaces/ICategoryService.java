package com.DuongNT.LuyenTap.service.interfaces;

import com.DuongNT.LuyenTap.dto.request.CreateCategoryRequest;
import com.DuongNT.LuyenTap.dto.response.CreateCategoryResponse;
import com.DuongNT.LuyenTap.dto.response.GetAccountResponse;
import com.DuongNT.LuyenTap.dto.response.GetCategoryResponse;

import java.util.List;

public interface ICategoryService {
    CreateCategoryResponse createCategory(CreateCategoryRequest request);
    List<GetCategoryResponse> getAllCategory();
    GetCategoryResponse getCategoryById(int id);
    boolean deleteCategory(int id);
    GetCategoryResponse updateCategory(int id, CreateCategoryRequest request);
}
