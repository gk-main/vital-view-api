package org.main.vitalview.dashboard.service;

import org.main.vitalview.dashboard.dto.DashboardResDto;
import org.main.vitalview.global.response.ApiResponse;

public interface DashboardService {

    ApiResponse<DashboardResDto> getVitals();
}
