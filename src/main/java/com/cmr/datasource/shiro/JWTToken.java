package com.cmr.datasource.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author chenmengrui
 * @Description: TODO
 * @date 2019/11/11 19:08
 */
public class JWTToken implements AuthenticationToken {

    private String token;

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
