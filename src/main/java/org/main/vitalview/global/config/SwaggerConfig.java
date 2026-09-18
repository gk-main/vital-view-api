package org.main.vitalview.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    Info info = new Info()
            .title("광주AX 대시보드 API 명세서")
            .description("광주AX 대시보드 API 문서입니다.")
            .version("v1.0.0");

    Server localServer = new Server()
            .url("http://localhost:8080/main")
            .description("로컬 환경");

    Server devServer = new Server()
            .url("https://vital-view-api.ai-tank.co.kr/main")
            .description("HTTPS 개발 환경");

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(info)
                .servers(List.of(localServer, devServer));
    }
}