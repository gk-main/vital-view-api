package org.main.vitalview.dashboard.dto;

import lombok.Data;

@Data
public class BloodSugarDto {
    private String measuredAt; // 측정일시
    private String timingType; // 측정시점
    private int glucoseValue; // 혈당수치
}
