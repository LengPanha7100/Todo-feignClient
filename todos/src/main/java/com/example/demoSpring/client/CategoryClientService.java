package com.example.demoSpring.client;

import com.example.demoSpring.model.APIResponse;
import com.example.demoSpring.model.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "category-service" , url = "http://category-api:8888/api/v1/category")
public interface CategoryClientService {
    @GetMapping("/{id}")
    ResponseEntity<APIResponse<Category>> getCategoryById(@PathVariable Long id);
}
