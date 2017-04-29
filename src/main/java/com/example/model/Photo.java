package com.example.model;

import javax.persistence.*;
import java.sql.Blob;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by maja on 26.03.17.
 */

@Entity
@Table(name = "photo")
public class Photo {

    public Photo(){};

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private Blob image;

     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

}
