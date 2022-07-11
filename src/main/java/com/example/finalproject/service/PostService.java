package com.example.finalproject.service;

import com.example.finalproject.models.Post;
import com.example.finalproject.repository.GetPostByParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private GetPostByParam getPostByParam;
    @Autowired
    public PostService(GetPostByParam getPostByParam) {
        this.getPostByParam = getPostByParam;
    }

    public List<Post> getPostsByParam(String author, String tag, LocalDate startDate, LocalDate endDate){
        return getPostByParam.getPostsByParam(author, tag, startDate, endDate);
    }
}
