package com.example.finalproject.repository;

import com.example.finalproject.models.Author;
import com.example.finalproject.models.Subscriber;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
