package com.gmail.etauroginskaya.finalcontrolwork.service.model;

import com.gmail.etauroginskaya.finalcontrolwork.service.validator.annotations.NotEarlierYear;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class DiscountDTO {

    @Null
    private Long id;
    private Long userID;
    @NotBlank
    private String title;
    private String percent;
    @NotNull
    @NotEarlierYear
    private String expirationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
