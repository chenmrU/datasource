package com.cmr.datasource.shiro;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cmr.datasource.utils.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author chenmengrui
 * @Description: jwt工具类
 * @date 2019/11/11 11:35
 */
@Slf4j
public class JWTUtil {

    /**
     * 校验token是否正确
     * @param token
     * @param username
     * @param secret
     * @return
     */
    public static boolean verify(String token, String username, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     * @param token
     * @return
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名，5min后过期
     * @param username
     * @param secret
     * @return
     */
    public static String sign(String username, String secret) {
        try {
            ShiroProperties shiroProperties = SpringContextUtil.getBean(ShiroProperties.class);
            Date date = new Date(System.currentTimeMillis() + shiroProperties.getJwtTimeOut());
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withClaim("username", username)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            log.error("sign token fail username is {}, secret is {}, errorMsg is {}", username, secret, e.getMessage());
            return null;
        }
    }

}
