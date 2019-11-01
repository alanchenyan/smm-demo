package com.alanchen.smmdemo.framework.auth;

import java.io.Serializable;

/**
 * @author Alan Chen
 * @description
 * @date 2019-10-31
 */
public class JwtToken implements Serializable {

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}