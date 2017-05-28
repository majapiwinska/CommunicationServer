package com.example.repository;

import com.example.model.Snap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maja on 09.04.17.
 */
@Repository
public interface SnapRepository extends JpaRepository<Snap, Long> {

    List<Snap> findByReceiverId(Long receiverId);

}
