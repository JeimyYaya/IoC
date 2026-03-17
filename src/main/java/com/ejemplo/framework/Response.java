package com.ejemplo.framework;

public class Response {

    private int status = 200;
    private String contentType = "text/html";

    public int getStatus() {
        return status;
    }

    public String getContentType() {
        return contentType;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}