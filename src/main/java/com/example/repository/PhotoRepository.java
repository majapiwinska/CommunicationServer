package com.example.repository;

import com.example.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by maja on 26.03.17.
 */
@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
