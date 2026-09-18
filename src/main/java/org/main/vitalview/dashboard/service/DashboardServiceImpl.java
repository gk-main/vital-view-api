package org.main.vitalview.dashboard.service;

import lombok.RequiredArgsConstructor;
import org.main.vitalview.dashboard.dto.DashboardResDto;
import org.main.vitalview.global.response.ApiResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    @Override
    public ApiResponse<DashboardResDto> getVitals() {
        return null;
    }
}
