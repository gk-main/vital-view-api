package org.main.vitalview.dashboard.dto;

import lombok.Data;

@Data
public class BloodPressureDto {
    private String measuredAt; // 측정일시
    private int sbp; // 최고혈압
    private int dbp; // 최저혈압
}
