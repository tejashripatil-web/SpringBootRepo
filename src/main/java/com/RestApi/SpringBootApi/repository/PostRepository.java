package com.RestApi.SpringBootApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RestApi.SpringBootApi.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>
{

}
