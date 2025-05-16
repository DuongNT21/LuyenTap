package com.DuongNT.LuyenTap.service.impl;

import com.DuongNT.LuyenTap.dto.request.CreateCategoryRequest;
import com.DuongNT.LuyenTap.dto.response.CreateCategoryResponse;
import com.DuongNT.LuyenTap.dto.response.GetAccountResponse;
import com.DuongNT.LuyenTap.dto.response.GetCategoryResponse;
import com.DuongNT.LuyenTap.entity.Category;
import com.DuongNT.LuyenTap.repository.CategoryRepository;
import com.DuongNT.LuyenTap.service.interfaces.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public CreateCategoryResponse createCategory(CreateCategoryRequest request) {
        Category category = new Category();
        CreateCategoryResponse response = new CreateCategoryResponse();
        category.setName(request.getName());
        response.setName(request.getName());
        category.setActive(true);
        categoryRepository.save(category);
        return response;
    }

    @Override
    public List<GetCategoryResponse> getAllCategory() {
        List<GetCategoryResponse> responses = new ArrayList<>();
//        List<Category> categories = categoryRepository.findAll();
//        for (Category category : categories){
//            if(category.isActive() == true){
//                GetCategoryResponse item = new GetCategoryResponse();
//                item.setName(category.getName());
//                responses.add(item);
//            }
//        }
        List<Category> categories = categoryRepository.findAllByActive();
        for (Category category : categories){
            GetCategoryResponse item = new GetCategoryResponse();
            item.setName(category.getName());
            responses.add(item);
        }
        return responses;
    }

    @Override
    public GetCategoryResponse getCategoryById(int id) {
        Category category = categoryRepository.findById(id).orElse(null);
        GetCategoryResponse response = new GetCategoryResponse();
        response.setName(category.getName());
        return response;
    }

    @Override
    public boolean deleteCategory(int id) {
        Category category = categoryRepository.findById(id).orElse(null);
        category.setActive(false);
        categoryRepository.save(category);
        return true;
    }

    @Override
    public GetCategoryResponse updateCategory(int id, CreateCategoryRequest request) {
        Category category = categoryRepository.findById(id).orElse(null);
        GetCategoryResponse response = new GetCategoryResponse();
        category.setName(request.getName());
        categoryRepository.save(category);
        response.setName(category.getName());
        return response;
    }

}
