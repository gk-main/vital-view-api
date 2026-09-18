package org.main.vitalview.dashboard.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.main.vitalview.dashboard.dto.DashboardResDto;
import org.main.vitalview.global.response.ApiResponse;
import org.main.vitalview.dashboard.service.DashboardService;
import org.main.vitalview.global.transaction.annotation.SaveDBOutbound;
import org.springframework.web.bind.annotation.*;

@Tag(name="Dashboard Controller", description = "DashBoard API 엔드포인트")
@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashBoardController {

    private final DashboardService dashboardService;

    @PostMapping("/vitals")
    @SaveDBOutbound(apiName = "EMR 환자 생체정보 수신 API")
    @Operation(summary="환자 생체정보 수신", description = "이지케어텍 EMR로부터 환자의 생체정보를 수신한다.")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "수신 성공")
    public ApiResponse<?> getVitals(@RequestBody DashboardResDto response) {
        System.out.println(response);
        return ApiResponse.success(null, "성공");
    }
}
