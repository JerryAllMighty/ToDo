package com.main.todo.domain.item;

import com.main.todo.domain.Category;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Builder
@DiscriminatorValue("M")
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends Item {

    private String director;

    private String actor;

    @ManyToMany
    private List<Category> categoryList = new ArrayList<>();
}
