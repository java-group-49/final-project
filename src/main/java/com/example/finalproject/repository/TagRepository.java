package com.example.finalproject.repository;

import com.example.finalproject.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

    void deleteTag(String name);
}