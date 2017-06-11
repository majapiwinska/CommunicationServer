package com.example.model.dto;

/**
 * Created by szymon on 11.06.17.
 */
public class GetSnapDto {

    private String senderEmail;
    private String photo;

    public GetSnapDto() {
    }

    public GetSnapDto(String senderEmail, String photo) {
        this.senderEmail = senderEmail;
        this.photo = photo;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
