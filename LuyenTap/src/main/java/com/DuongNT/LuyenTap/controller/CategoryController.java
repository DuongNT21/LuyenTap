package com.DuongNT.LuyenTap.controller;

import com.DuongNT.LuyenTap.dto.request.CreateCategoryRequest;
import com.DuongNT.LuyenTap.dto.response.CreateCategoryResponse;
import com.DuongNT.LuyenTap.dto.response.GetCategoryResponse;
import com.DuongNT.LuyenTap.service.impl.CategoryService;
import com.DuongNT.LuyenTap.service.interfaces.IAccountService;
import com.DuongNT.LuyenTap.service.interfaces.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final ICategoryService categoryService;

    @PostMapping("/create")
    public CreateCategoryResponse createCategory(@RequestBody CreateCategoryRequest request) {
        return categoryService.createCategory(request);
    }

    @GetMapping("/get")
    public List<GetCategoryResponse> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/get/{id}")
    public GetCategoryResponse getCategoryById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
    }

    @PutMapping("/update/{id}")
    public GetCategoryResponse updateCategory(@PathVariable int id, @RequestBody CreateCategoryRequest request) {
        return categoryService.updateCategory(id, request);
    }
}
