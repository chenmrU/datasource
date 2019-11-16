package com.cmr.datasource.shiro;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author chenmengrui
 * @Description: TODO
 * @date 2019/11/16 13:50
 */
@Component
@ConfigurationProperties("shiro")
@Data
public class ShiroProperties {

    private String anonUrl;

    private Long jwtTimeOut = 86400L;

}
