package com.example.demoSpring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {
    private String name;

    public Category toEntity(){
        return new Category(null,this.name);
    }
    public Category toEntity(Long id){
        return new Category(id,this.name);
    }
}
