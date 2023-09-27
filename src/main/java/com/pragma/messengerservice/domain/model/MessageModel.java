package com.pragma.messengerservice.domain.model;

public class MessageModel {
    private String message;
    private String cellphone;

    public MessageModel() {
    }
    public MessageModel(String message, String cellphone) {
        this.message = message;
        this.cellphone = cellphone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}
