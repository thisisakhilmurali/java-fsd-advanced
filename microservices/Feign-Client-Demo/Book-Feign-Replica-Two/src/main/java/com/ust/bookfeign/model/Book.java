package com.ust.bookfeign.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Integer bookId;
    private String bookName;
    private Double bookCost;

}
