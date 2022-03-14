package com.webapp.bookmyshowapp.util;

import java.util.Map;

import com.webapp.bookmyshowapp.bean.ApiError;
import com.webapp.bookmyshowapp.constant.ConstantUtil;
import org.springframework.http.ResponseEntity;
public abstract class BaseExceptionHandler {

    /*
     *  HTTP-Code 400
     *
     *  Return if the request payload could not be validated by the server
     *
     *  The client should not repeat the request without the modification
     *
     *  @params message
     */

    protected ResponseEntity<Object> handle400BadRequest(Object message){
        if(message instanceof Map<?,?>) {
            String msg="";
            for(Map.Entry<String, String> entry : ((Map<String,String>) message).entrySet()) {
                message = msg.concat(entry.getValue());
            }
        }
        return apiException(message, ConstantUtil.STATUS_CODE_BAD_REQUEST);
    }

    protected ResponseEntity<Object> handle400BadRequest(Object message, Throwable cause){
        return apiException(message, ConstantUtil.STATUS_CODE_BAD_REQUEST,cause);
    }
    /*
     *  HTTP-Code 602
     *
     *  Return if the response payload have some issue by the Databaseserver
     *
     *  The server should not repeat the request without the modification
     *
     *  @params message
     */

    protected ResponseEntity<Object> handle602DatabaseError(Object message){
        return apiException(message, ConstantUtil.STATUS_CODE_DATABASE_ERROR);
    }

    protected ResponseEntity<Object> handle602DatabaseError(Object message, Throwable cause){
        return apiException(message, ConstantUtil.STATUS_CODE_DATABASE_ERROR,cause);
    }

    /*
     *  HTTP-Code 500
     *
     *  Return if the response payload have some issue by the server
     *
     *  The server should not repeat the request without the modification
     *
     *  @params message
     */

    protected ResponseEntity<Object> handle500InternalServerError(Object message){
        if(message instanceof Map<?,?>) {
            String msg="";
            for(Map.Entry<String, String> entry : ((Map<String,String>) message).entrySet()) {
                message = msg.concat(entry.getValue());
            }
        }
        return apiException(message, ConstantUtil.STATUS_CODE_INTERNAL_SERVER_ERROR);
    }

    protected ResponseEntity<Object> handle500InternalServerError(Object message,Throwable cause){

        return apiException(message, ConstantUtil.STATUS_CODE_INTERNAL_SERVER_ERROR,cause);
    }


    /*
     *  HTTP-Code 601
     *
     *  Return if the response payload have some issue by the Elasticsearch Server
     *
     *  The server should not repeat the request without the modification
     *
     *  @params message
     */

    protected ResponseEntity<Object> handle404ResourceNotFoundRequest(Object message){
        if(message instanceof Map<?,?>) {
            String msg="";
            for(Map.Entry<String, String> entry : ((Map<String,String>) message).entrySet()) {
                message = msg.concat(entry.getValue());
            }
        }
        return apiException(message, ConstantUtil.STATUS_CODE_RESOURCE_NOT_FOUND);
    }

    protected ResponseEntity<Object> handle404ResourceNotFoundRequest(Object message,Throwable cause){

        return apiException(message, ConstantUtil.STATUS_CODE_RESOURCE_NOT_FOUND,cause);
    }

    /*
     * @params message
     * @params status
     * @return ResponseEntity<Object>
     */

    protected ResponseEntity<Object> handle200OkRequest(Object message){

        return ResponseEntity.status(ConstantUtil.STATUS_CODE_OK).body(message);
    }


    /*
     * @params message
     * @params status
     * @return CompletableFututre<ResponseEntity<Object>>
     *
     */
    private ResponseEntity<Object> apiException(Object message, int status){
        ApiError apiError = new ApiError(message,status);
        return ResponseEntity.status(status).body(apiError);
    }


    /*
     * @params message
     * @params status
     * @params cause
     * @return CompletableFututre<ResponseEntity<Object>>
     *
     */
    private ResponseEntity<Object> apiException(Object message, int status, Throwable cause){
        ApiError apiError = new ApiError(message,status,cause);
        return ResponseEntity.status(status).body(apiError);
    }






}
