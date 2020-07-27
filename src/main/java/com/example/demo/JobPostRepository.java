package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface JobPostRepository extends CrudRepository<JobPosts, Long> {
    Iterable<JobPosts> findAllByIdGreaterThanOrderByName(long id);


}
