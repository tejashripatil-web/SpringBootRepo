package com.RestApi.SpringBootApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestApi.SpringBootApi.dto.PostDto;
import com.RestApi.SpringBootApi.entity.Post;
import com.RestApi.SpringBootApi.repository.PostRepository;
import com.RestApi.SpringBootApi.service.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired PostRepository postRepository;
	

	
}
