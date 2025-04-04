package jyplord.calender.Service;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;


import jakarta.servlet.http.HttpSession;
import jyplord.calender.DTO.request.DeleteRequest;
import jyplord.calender.DTO.request.ReviseRequest;
import jyplord.calender.DTO.request.SaveRequest;
import jyplord.calender.DTO.response.AllPlanResponse;

import jyplord.calender.DTO.response.LoginResponse;
import jyplord.calender.Entity.PlanEntity;
import jyplord.calender.Entity.UserEntity;
import jyplord.calender.Repository.PlanRepository;

import jyplord.calender.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;


@Service
@Log4j2
@RequiredArgsConstructor
public class PlanService{
    private final PlanRepository planRepository;
    private final UserRepository userRepository;


    // 계획세우고 저장하기!
    public String savePlan(SaveRequest dto, @SessionAttribute HttpSession session){
        LoginResponse user = (LoginResponse) session.getAttribute("loginUser");
        String name = user.getName();

        UserEntity userName = new UserEntity(name);

        PlanEntity entity = new PlanEntity(dto.getPlanTitle(),dto.getPlanBody(), userName);

        planRepository.save(entity);
            return "저장 성공";
    }


    // 계획 불러오기
    public List<AllPlanResponse> getPlanList(Long userID, int page){
        Pageable pageable = PageRequest.of(page, 10);
        List<PlanEntity> allPlanEntityList = planRepository.findByUserID(userID, pageable).getContent();

        List<AllPlanResponse> allPlanResponseList = new ArrayList<>();

        for(int i = 0; i< allPlanEntityList.size(); i++){
            AllPlanResponse dto = new AllPlanResponse(allPlanEntityList.get(i).getPlanID(),
                    allPlanEntityList.get(i).getPlanTitle(),
                    allPlanEntityList.get(i).getPlanBody(),
                    allPlanEntityList.get(i).getCreatedAt(),
                    allPlanEntityList.get(i).getModifiedAt());
            allPlanResponseList.add(dto);
        }

        return allPlanResponseList;
    }


    public Boolean modifyPlan(ReviseRequest dto, String planTitle ,HttpSession session){
        planRepository.findByPlanTitle(planTitle);


        return true;
    }
    public Boolean deletePlan(DeleteRequest dto){
        try {
            UserEntity comparePasswordEntity = userRepository.findByID(new UserEntity(dto.getUserID(), dto.getPassword()));

            if(dto.getPassword().equals(comparePasswordEntity.getPassword())){
                planRepository.deletePlan(dto.getPlan());
                return true;
            }else {
                throw new UserInvalidException("Invalid Password");
            }

        }catch (SQLException e){
            log.error(e);
            return false;
        }catch (UserInvalidException passwordError){
            log.error(passwordError);
            return false;
        }

    }

}
