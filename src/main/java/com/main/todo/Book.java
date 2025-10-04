package com.main.todo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@DiscriminatorValue("B")
@NoArgsConstructor
@AllArgsConstructor
public class Book extends Item {
    private String author;
    private String isbn;
}
