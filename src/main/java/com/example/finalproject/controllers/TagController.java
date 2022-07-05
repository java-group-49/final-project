package com.example.finalproject.controllers;

import com.example.finalproject.models.Tag;
import com.example.finalproject.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {

    private final TagService tagService;

@Autowired
    public TagController(TagService tagService) {this.tagService = tagService;
    }


    @PostMapping("/tag")
    public ResponseEntity <Void> addTag(@RequestBody Tag tag){
        tagService.add(tag);
            return ResponseEntity.status(201).build();



}}