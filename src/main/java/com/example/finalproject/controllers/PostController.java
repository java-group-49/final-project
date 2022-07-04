package com.example.finalproject.controllers;

import com.example.finalproject.models.Post;
import com.example.finalproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<Post>> getPostsByParam(
            @RequestParam String author,
            @RequestParam String tag,
            @RequestParam(name = "start_date")@DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate startDate,
            @RequestParam(name = "end_date")@DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate endDate
            ){
        System.out.println(author + " " + tag + " " + startDate + " " + endDate);
        return ResponseEntity.status(201).body(postService.getPostsByParam());
    }
}
