package org.main.vitalview.dashboard.dto;

import lombok.Data;

@Data
public class OxygenSaturationDto {
    private String measuredAt; // 측정일시
    private int spo2Value; // 산소포화도 수치
}
