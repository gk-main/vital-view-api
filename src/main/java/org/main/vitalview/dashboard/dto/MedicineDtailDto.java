package org.main.vitalview.dashboard.dto;

import lombok.Data;

@Data
public class MedicineDtailDto {
    private String medCode; // 약제코드
    private String medName; // 약제명
    private String category; // 약품분류명
    private int dosage; // 1회 투여량
    private int frequency; // 1일 투여 횟수
    private int durationDays; // 총 투약 일수
    private String instructions; // 용법 및 복용 안내
}
