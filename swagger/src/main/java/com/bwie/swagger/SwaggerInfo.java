package com.bwie.swagger;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class SwaggerInfo {

    private String groupName = "controller";

    private String basePackage;

    private String antPath;

    private String title = "HTTP API";

    private String description = "管理端接口";

    private String license = "Apache License Version 2.0";
}