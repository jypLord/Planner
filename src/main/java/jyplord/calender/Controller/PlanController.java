package jyplord.calender.Controller;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jyplord.calender.DTO.request.DeleteRequest;
import jyplord.calender.DTO.request.ReviseRequest;
import jyplord.calender.DTO.request.SaveRequest;
import jyplord.calender.DTO.response.AllPlanResponse;
import jyplord.calender.Service.PlanService;
import org.springframework.http.MediaType;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PlanController {
    private final PlanService planService;

    //생성자 주입
    public PlanController(PlanService plannerService) {
        this.planService = plannerService;
    }

    @PostMapping(value = "/plans")
    public ResponseEntity<String> planning(@RequestBody @Valid SaveRequest dto,@SessionAttribute HttpSession session){
        planService.savePlan(dto, session);

        return ResponseEntity.ok("Save complete!");
    }


    @GetMapping(value = "/plans/{userID}")
    public List<AllPlanResponse> getPlanList(@PathVariable Long userID, @RequestParam(defaultValue = "0") int paging){
        return planService.getPlanList(userID, paging);
    }

    @GetMapping(value = "/plans/{id}/{planTitle}")
    public List


    //글, 이름 수정
    @PutMapping(value = "/plans/{planTitle}")
    public ResponseEntity<String> modifyPlan(@RequestBody @Valid ReviseRequest dto,
                                             @PathVariable String planTitle, HttpSession session){
        boolean result = planService.modifyPlan(dto,planTitle,session);
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

