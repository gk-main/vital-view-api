package org.main.vitalview.global.response;

import lombok.Data;

@Data
public class CommonResponse<T> {
    private boolean success;
    private int status;
    private String message;
    private T data;

    // 성공 응답 생성자
    public static <T> CommonResponse<T> success(T data, String message) {
        CommonResponse<T> response = new CommonResponse<>();
        response.success = true;
        response.status = 200;
        response.message = message;
        response.data = data;
        return response;
    }

    // 실패 응답 생성자
    public static <T> CommonResponse<T> error(int status, String message) {
        CommonResponse<T> response = new CommonResponse<>();
        response.success = false;
        response.status = status;
        response.message = message;
        response.data = null;
        return response;
    }
}
