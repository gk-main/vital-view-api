package org.main.vitalview.dashboard.dto;

import lombok.Data;

import java.util.List;

@Data
public class DashboardResDto {
    private PatientDto patient; // 환자 기본정보
    private List<BloodPressureDto> bloodPressureList; // 혈당
    private List<BloodSugarDto> bloodSugarList; // 혈압
    private List<OxygenSaturationDto> oxygenSaturationList; // 산소포화도
    private List<GlycatedHemoglobinDto> glycatedHemoglobinList; // 당화혈색소
    private List<MedicineDtailDto> medicineDtailList; // 약제 세부 내역
}
