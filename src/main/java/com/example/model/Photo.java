package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Blob;
import java.sql.SQLException;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by maja on 26.03.17.
 */

@Entity
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

    public String getImage() {
        byte[] bytes = null;
        try {
            bytes = image.getBytes(1, (int) image.length());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bytes.toString();
    }

    public void setImage(String image) {
        byte[] bytes = image.getBytes();
        Blob blob = null;
        try {
            blob = new javax.sql.rowset.serial.SerialBlob(bytes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.image = blob;
    }

}
