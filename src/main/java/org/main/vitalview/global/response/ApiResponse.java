package org.main.vitalview.global.response;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private boolean success;
    private int status;
    private String message;
    private T data;

    // 성공 응답 생성자
    public static <T> ApiResponse<T> success(T data, String message) {
        ApiResponse<T> response = new ApiResponse<>();
        response.success = true;
        response.status = 200;
        response.message = message;
        response.data = data;
        return response;
    }

    // 실패 응답 생성자
    public static <T> ApiResponse<T> error(int status, String message) {
        ApiResponse<T> response = new ApiResponse<>();
        response.success = false;
        response.status = status;
        response.message = message;
        response.data = null;
        return response;
    }
}
