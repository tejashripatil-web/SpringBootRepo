package com.RestApi.SpringBootApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RestApi.SpringBootApi.entity.Book;

public interface BookRepository extends JpaRepository<Book,Long>{

}
