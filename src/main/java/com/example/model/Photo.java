package com.example.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by maja on 26.03.17.
 */

@Entity
@Table(name = "photo")
public class Photo {

    public Photo() {
    }

    public Photo(String image) {
        this.image = image;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Lob
    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
