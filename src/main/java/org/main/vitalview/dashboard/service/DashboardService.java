package org.main.vitalview.dashboard.service;

import org.main.vitalview.dashboard.dto.DashboardResDto;
import org.main.vitalview.global.response.CommonResponse;

public interface DashboardService {

    CommonResponse<DashboardResDto> getVitals();
}
