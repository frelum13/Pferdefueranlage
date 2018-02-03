/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.request;

/**
 *
 * @author lukas
 */
public class RequestJsonException extends RequestException {

    private final String jsonString;
    
    public RequestJsonException(String json, String message) {
        super(message);
        this.jsonString = json;
    }

    public RequestJsonException(String json, String message, Throwable cause) {
        super(message, cause);
        this.jsonString = json;
    }

    public RequestJsonException(String json, Throwable cause) {
        super(cause);
        this.jsonString = json;
    }

    public String getJsonString() {
        return jsonString;
    }
     
}
