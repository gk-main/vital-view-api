package org.main.vitalview.dashboard.dto;

import lombok.Data;

@Data
public class PatientDto {
    // 환자 정보
    private String patientId; // 환자ID
    private String patientName; // 환자이름
    private String startDate; // 조회일자
    private String doctorId; // 조회요청자(의료진)
    private String doctorName; // 의사이름
    private String admissionDate; // 입원일자
    private String dischargeDate; // 퇴원(예정)일자
}
