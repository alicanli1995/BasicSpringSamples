package com.pagination.springpagination.repo;

import com.pagination.springpagination.entity.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDto extends JpaRepository<Book,Long> {
}
