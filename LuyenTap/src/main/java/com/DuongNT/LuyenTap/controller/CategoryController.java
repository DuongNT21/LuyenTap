package com.DuongNT.LuyenTap.controller;

import com.DuongNT.LuyenTap.dto.request.CreateCategoryRequest;
import com.DuongNT.LuyenTap.dto.response.BaseResponse;
import com.DuongNT.LuyenTap.dto.response.CreateBookResponse;
import com.DuongNT.LuyenTap.dto.response.CreateCategoryResponse;
import com.DuongNT.LuyenTap.dto.response.GetCategoryResponse;
import com.DuongNT.LuyenTap.service.impl.CategoryService;
import com.DuongNT.LuyenTap.service.interfaces.IAccountService;
import com.DuongNT.LuyenTap.service.interfaces.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final ICategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse> createCategory(@RequestBody CreateCategoryRequest request) {
        CreateCategoryResponse response = categoryService.createCategory(request);
        return ResponseEntity.ok(
                new BaseResponse(
                        "200",
                        "Create category",
                        response
                )
        );
    }

    @GetMapping("/get")
    public ResponseEntity<BaseResponse> getAllCategory() {
        List<GetCategoryResponse> responses = categoryService.getAllCategory();
        return ResponseEntity.ok(
                new BaseResponse(
                        "200",
                        "Get all category",
                        responses
                )
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BaseResponse> getCategoryById(@PathVariable int id){
        GetCategoryResponse response = categoryService.getCategoryById(id);
        return ResponseEntity.ok(
                new BaseResponse(
                        "200",
                        "Get category",
                        response
                )
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BaseResponse> deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok(
                new BaseResponse(
                        "200",
                        "Delete category",
                        null
                )
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BaseResponse> updateCategory(@PathVariable int id, @RequestBody CreateCategoryRequest request) {
        GetCategoryResponse response = categoryService.updateCategory(id, request);
        return ResponseEntity.ok(
                new BaseResponse(
                        "200",
                        "Update category",
                        response
                )
        );
    }
}
