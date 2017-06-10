package com.example.model.dto;

import java.util.List;

/**
 * Created by maja on 02.05.17.
 */
public class SnapDto {

    private Long senderId;
    private String image;
    private List<String> receiversList;
    private int seconds;
    private boolean opened;

    public SnapDto() {
    }

    public SnapDto(Long senderId, String image, List<String> receiversList) {
        this.senderId= senderId;
        this.image = image;
        this.receiversList = receiversList;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getReceiversList() {
        return receiversList;
    }

    public void setReceiversList(List<String> receiversList) {
        this.receiversList = receiversList;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }
}
