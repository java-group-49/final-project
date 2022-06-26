package com.example.finalproject.repository;

import com.example.finalproject.models.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

}