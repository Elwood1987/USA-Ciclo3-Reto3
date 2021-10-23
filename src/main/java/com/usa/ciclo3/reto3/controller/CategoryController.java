package com.usa.ciclo3.reto3.controller;

import com.usa.ciclo3.reto3.model.Category;
import com.usa.ciclo3.reto3.service.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CategoryController {
    @Autowired
    private CategoryServices categoryServices;

    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryServices.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int id){
        return categoryServices.getCategory(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category){
        return  categoryServices.save(category);
    }
}
