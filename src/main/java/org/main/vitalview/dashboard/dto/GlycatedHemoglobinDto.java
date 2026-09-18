package org.main.vitalview.dashboard.dto;

import lombok.Data;

@Data
public class GlycatedHemoglobinDto {
    private String testDate; // 검사 시행일자
    private int hba1cValue; // 당화혈색소 수치
}
