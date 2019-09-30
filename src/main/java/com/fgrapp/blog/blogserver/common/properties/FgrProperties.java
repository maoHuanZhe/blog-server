package com.fgrapp.blog.blogserver.common.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * 自定义属性
 *
 * @author FGR on 2019/9/28
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:fgr.properties"})
@ConfigurationProperties(prefix = "fgr")
public class FgrProperties {

    private ShiroProperties shiro = new ShiroProperties();
    private boolean autoOpenBrowser = true;
    private String[] autoOpenBrowserEnv = {};
    private SwaggerProperties swagger = new SwaggerProperties();
}
