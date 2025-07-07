package com.an.library.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookRequestDTO {
    private String title;
    private LocalDate publishDate;
    private Long authorId;
    private Long genreId;
}
