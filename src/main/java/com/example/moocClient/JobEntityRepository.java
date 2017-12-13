package com.example.moocClient;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobEntityRepository extends JpaRepository<JobEntity, String> {
    List<JobEntity> findAll();
    List<JobEntity> findAllById(Integer id);
}
