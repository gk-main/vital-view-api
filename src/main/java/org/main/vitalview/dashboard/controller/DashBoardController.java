package org.main.vitalview.dashboard.controller;

import lombok.RequiredArgsConstructor;
import org.main.vitalview.dashboard.dto.DashboardResDto;
import org.main.vitalview.global.response.ApiResponse;
import org.main.vitalview.dashboard.service.DashboardService;
import org.main.vitalview.global.transaction.annotation.SaveDBOutbound;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashBoardController {

    private final DashboardService dashboardService;

    @PostMapping
    @RequestMapping("/vitals")
    @SaveDBOutbound(apiName = "EMR 환자 생체정보 수신 API")
    public ApiResponse<?> getVitals(@RequestBody DashboardResDto response) {
        System.out.println(response);
        return ApiResponse.success(null, "성공");
    }
}
