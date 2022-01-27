package com.pagination.springpagination.controller;


import com.pagination.springpagination.entity.model.Book;
import com.pagination.springpagination.repo.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookDto bookDto;

    @GetMapping
    public Page<Book> pagination(@RequestParam Integer pageSize,
                                 @RequestParam Integer page){
        Pageable pageable = PageRequest.of(page,pageSize);
        return bookDto.findAll(pageable);
    }

    @GetMapping("/find-all")
    public Page<Book> pagination(Pageable pageable){
        //send a count query it's slower than slice
        return bookDto.findAll(pageable);
    }

    @GetMapping("/slice-all")
    public Slice<Book> slice(Pageable pageable){
        return bookDto.findAll(pageable);
    }

}
