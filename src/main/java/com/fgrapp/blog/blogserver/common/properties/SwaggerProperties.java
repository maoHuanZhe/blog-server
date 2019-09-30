package com.fgrapp.blog.blogserver.common.properties;

import lombok.Data;

/**
 * SwaggerProperties
 *
 * @author FGR on 2019/9/28
 */
@Data
public class SwaggerProperties {
    private String basePackage;
    private String title;
    private String description;
    private String version;
    private String author;
    private String url;
    private String email;
    private String license;
    private String licenseUrl;
}
