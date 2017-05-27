package com.example.model.dto;

import java.util.List;

/**
 * Created by maja on 02.05.17.
 */
public class SnapDto {

    private String senderEmail;
    private String image;
    private List<Long> receiversList;

    public SnapDto() {
    }

    public SnapDto(String senderEmail, String image, List<Long> receiversList) {
        this.senderEmail = senderEmail;
        this.image = image;
        this.receiversList = receiversList;
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

    public List<Long> getReceiversList() {
        return receiversList;
    }

    public void setReceiversList(List<Long> receiversList) {
        this.receiversList = receiversList;
    }
}
