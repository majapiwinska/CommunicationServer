package com.example.model.dto;

/**
 * Created by maja on 02.05.17.
 */
public class SnapDto {

    private String senderEmail;

    private String image;

    public SnapDto() {
    }

    public SnapDto(String senderEmail, String image) {
        this.senderEmail = senderEmail;
        this.image = image;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
