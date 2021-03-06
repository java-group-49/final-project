package com.example.finalproject.controllers;

import com.example.finalproject.models.Post;
import com.example.finalproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getPostsByParam(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String tag,
            @RequestParam(name = "start_date", required = false)@DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate startDate,
            @RequestParam(name = "end_date", required = false)@DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate endDate
            ){
        return ResponseEntity.status(200).body(postService.getPostsByParam(author, tag, startDate, endDate));
    }

    @PostMapping("/post")
    public ResponseEntity<Void> add(@RequestBody Post post){
        postService.add(post);
        return ResponseEntity.ok().build();
    }
}
