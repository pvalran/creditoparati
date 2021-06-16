/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pima.creditoparati.utilidades;

/**
 *
 * @author Rodrigo_Diaz
 */
public class ResponseDTO {

    private Object data;
    private String message;
    private Boolean result;

    public ResponseDTO(Object data, String message, Boolean result) {
        this.data = data;
        this.message = message;
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
