package jyplord.calender.Controller;

import jyplord.calender.DTO.planningDTO;

import jyplord.calender.Service.CalendarService;
import org.springframework.http.MediaType;


import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;


@RestController
public class planController {
    private final CalendarService calendarService;

    //생성자 주입
    public planController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @PostMapping(value = "/planner" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public String planning(@RequestBody planningDTO dto){
        calendarService.savePlan(dto);

        return "";
    }


    @GetMapping(value = "/planner/list")
    public ArrayList<planningDTO> getPlanList(@RequestParam String id , @RequestParam LocalDateTime writeDate, @RequestParam int paging){
        return calendarService.getPlanList(id, writeDate, paging);
    }

    //글, 이름 수정
    @PutMapping(value = "/planner/revise", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String revisePlan(planningDTO dto){
        calendarService.revisePlan(dto);
        return "";
    }

    @DeleteMapping(value = "/planner/list", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deletePlan(planningDTO dto){
        calendarService.deletePlan(dto);
        return "";
    }
}

