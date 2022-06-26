package com.example.finalproject.service;

import com.example.finalproject.models.Tag;
import com.example.finalproject.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    private final TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public void add(Tag tag) {
        tagRepository.save(tag);
    }

    public Tag getTag(String name) {
        return tagRepository.getTag(name);
    }

    public void deleteTag(String name) {
        tagRepository.deleteTag(name);
    }
}