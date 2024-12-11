package com.example.demoSpring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TodoRequest {
    private String title;
    private String description;
    private Long categoryResponse;
    public Todo toEntity(){
        return new Todo(null,this.title,this.description,this.categoryResponse);
    }
    public Todo toEntity(Long id){
        return new Todo(id,this.title,this.description,this.categoryResponse);
    }
}
