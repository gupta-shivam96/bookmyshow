package com.webapp.bookmyshowapp.bean;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ApiError {
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timeStamp;
    private int status;
    private Object message;
    private String debugMessage = "";

    /*
     * Initialize current date
     */
    private ApiError() {
        timeStamp = LocalDateTime.now();
    }

    /*
     * @param Object
     */
    public ApiError(Object message) {
        this();
        this.message = message;
    }

    /*
     * @params object
     * @params message
     */
    public ApiError(Object message, int status) {
        this();
        this.message= message;
        this.status = status;
    }

    /*
     * @params object
     * @params message
     * @params exception
     */

    public ApiError(Object message, int status, Throwable ex) {
        this();
        this.message = message;
        this.status = status;
        this.debugMessage = ex.getLocalizedMessage();
    }



}
