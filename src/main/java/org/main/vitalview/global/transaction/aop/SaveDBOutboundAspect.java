package org.main.vitalview.global.transaction.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.main.vitalview.global.transaction.annotation.SaveDBOutbound;
import org.main.vitalview.global.transaction.entity.OutboundHistoryEntity;
import org.main.vitalview.global.transaction.service.OutboundLogService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
@RequiredArgsConstructor
public class SaveDBOutboundAspect {

    private final OutboundLogService outboundLogService;

    @Around("@annotation(saveDBOutbound)")
    public Object logOutboundTransaction(ProceedingJoinPoint joinPoint, SaveDBOutbound saveDBOutbound) throws Throwable {
        HttpServletRequest request = getCurrentHttpRequest();

        OutboundHistoryEntity history = new OutboundHistoryEntity();
        history.setApiName(saveDBOutbound.apiName());
        history.setCreateDate(LocalDateTime.now());

        if (request != null) {
            history.setRequestUrl(substringSafe(request.getRequestURI(), 100));
            history.setRequestMethod(request.getMethod());
            history.setClientIp(getClientIp(request));
            history.setRequestHeader(request.getHeader("User-Agent")); // 필요에 따라 주요 헤더 지정
        }

        // 파라미터 정보 직렬화 (필요시 JSON 형태로 변경 가능)
        history.setRequestBody(Arrays.toString(joinPoint.getArgs()));

        Object result = null;
        try {
            result = joinPoint.proceed();
            history.setStatusCode("200");
            history.setResponseResult(result.toString());
        } catch (Exception e) {
            history.setStatusCode("500");
            history.setErrorMessage(e.getMessage());
            throw e;
        } finally {
            try {
                outboundLogService.saveLog(history);
            } catch (Exception logException) {
                // 로그 저장 실패가 메인 트랜잭션에 영향을 주지 않도록 예외 캡처 처리
            }
        }

        return result;
    }

    private HttpServletRequest getCurrentHttpRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attributes != null ? attributes.getRequest() : null;
    }

    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        return (ip != null && !ip.isEmpty()) ? ip : request.getRemoteAddr();
    }

    // VARCHAR(100) 길이 제한 초과 시 잘라내는 헬퍼 메서드
    private String substringSafe(String value, int length) {
        if (value == null) return null;
        return value.length() > length ? value.substring(0, length) : value;
    }
}