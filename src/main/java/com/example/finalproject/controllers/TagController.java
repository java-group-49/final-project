package com.example.finalproject.controllers;

import com.example.finalproject.models.Tag;
import com.example.finalproject.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TagController {
    private final TagService tagService;

    @Autowired
    public TagController(TagService tag) {
        this.tagService = tag;
    }

    @PostMapping("/addTag")
    public ResponseEntity<Void> add(@RequestBody Tag tag) {
        tagService.add(tag);
        return ResponseEntity.status(201).build();
    }
    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Void> deleteTag(@PathVariable String name) {
        tagService.deleteTag(name);
        return ResponseEntity.status(202).build();
    }
}