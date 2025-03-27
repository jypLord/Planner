package jyplord.calender.Controller;


import jakarta.validation.Valid;
import jyplord.calender.DTO.request.DeleteRequest;
import jyplord.calender.DTO.request.ReviseRequest;
import jyplord.calender.DTO.request.SaveRequest;
import jyplord.calender.DTO.response.PlanResponse;
import jyplord.calender.Service.PlanService;
import org.springframework.http.MediaType;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
public class planController {
    private final PlanService planService;

    //생성자 주입
    public planController(PlanService plannerService) {
        this.planService = plannerService;
    }

    @PostMapping(value = "/planner" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> planning(@RequestBody @Valid SaveRequest dto){
        boolean result = planService.savePlan(dto);
        if(result){
            return ResponseEntity.ok("Save complete!");
        }else{
            return ResponseEntity.badRequest().body("Save Failed");
        }

    }


    @GetMapping(value = "/planner/list")
    public List<PlanResponse> getPlanList(@RequestParam String id , @RequestParam LocalDateTime writeDate, @RequestParam int paging){
        return planService.getPlanList(id, writeDate, paging);
    }

    //글, 이름 수정
    @PutMapping(value = "/planner/revise", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> revisePlan(@RequestBody @Valid ReviseRequest dto){
        boolean result = planService.revisePlan(dto);
        if(result){
            return ResponseEntity.ok("Revised Complete!");
        }else {
            return ResponseEntity.badRequest().body("Revise Failed");
        }
    }


    @DeleteMapping(value = "/planner/list", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deletePlan(@RequestBody @Valid DeleteRequest dto){
        boolean result = planService.deletePlan(dto);
        if(result){
            return ResponseEntity.ok("Delete Complete!");
        }else{
            return ResponseEntity.badRequest().body("Delete Failed");
        }
    }
}

