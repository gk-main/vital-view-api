package org.main.vitalview.global.transaction.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_outbound_history")
@Data
@NoArgsConstructor
public class OutboundHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(name = "api_name", length = 100)
    private String apiName;

    @Column(name = "request_url", length = 100)
    private String requestUrl;

    @Column(name = "request_method", length = 100)
    private String requestMethod;

    @Column(name = "request_header", length = 100)
    private String requestHeader;

    @Column(name = "request_body", length = 300)
    private String requestBody;

    @Column(name = "response_result", length = 300)
    private String responseResult;

    @Column(name = "status_code", length = 100)
    private String statusCode;

    @Column(name = "client_ip", length = 100)
    private String clientIp;

    @Column(name = "error_message", length = 100)
    private String errorMessage;

    @Column(name = "create_date")
    private LocalDateTime createDate;
}

