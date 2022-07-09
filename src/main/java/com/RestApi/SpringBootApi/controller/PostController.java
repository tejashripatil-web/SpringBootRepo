package com.RestApi.SpringBootApi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RestApi.SpringBootApi.dto.PostDto;
import com.RestApi.SpringBootApi.entity.Post;
import com.RestApi.SpringBootApi.service.PostService;

@RestController
public class PostController {
	
	@Autowired PostService postService;
	
	@Autowired ModelMapper mapper;
	
	@PostMapping("/post")
	public Post createpost(@RequestBody PostDto postDto)
	{
		Post post = mapper.map(postDto, Post.class);
		
		return post;
	}

}
