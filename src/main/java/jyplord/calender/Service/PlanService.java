package jyplord.calender.Service;

import java.sql.*;
import java.time.LocalDateTime;

import java.util.Collections;
import java.util.List;


import jyplord.calender.DTO.request.DeleteRequest;
import jyplord.calender.DTO.request.ReviseRequest;
import jyplord.calender.DTO.request.SaveRequest;
import jyplord.calender.DTO.response.PlanResponse;

import jyplord.calender.Entity.PlanEntity;
import jyplord.calender.Entity.UserEntity;
import jyplord.calender.Repository.PlanRepository;

import jyplord.calender.Repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PlanService{
    private final PlanRepository planRepository;
    private final UserRepository userRepository;


    // 계획세우고 저장하기!
    public Boolean savePlan(SaveRequest dto) {
        try{
            planRepository.savePlan(dto);
            return true;
        }catch (SQLException error){
            return false;
        }

    }


    // 계획 불러오기
    public List<PlanResponse> getPlanList(String userID, LocalDateTime writeDate, int page){
        try{
            PlanEntity planEntity = new PlanEntity(userID, writeDate);

            return planRepository.findByID(planEntity, page);

        }catch (SQLException sqlError){
            sqlError.printStackTrace();

            //예외일 때 빈 리스트 리턴
            return Collections.emptyList();
        }

    }


    public Boolean revisePlan(ReviseRequest dto){
        try {
            //클라이언트에서 입력한 PW가 DB에 저장된 PW와 일치하는지 확인하기 위해 PW 조회 쿼리 실행
            UserEntity comparePasswordEntity = userRepository.findByID(new UserEntity(dto.getUserID(), dto.getPassword()));

            // 입력 PW와 실제 PW 동일성 확인
            if(dto.getPassword().equals(comparePasswordEntity.getPassword())){
                // 맞으면 plan 수정
                planRepository.revisePlan(dto.getUserID(),dto.getPlan());
                return true;
            }else {
                return false;
            }
        }catch (SQLException sqlError){
            sqlError.printStackTrace();
            return false;
        }

    }
    public Boolean deletePlan(DeleteRequest dto){
        try {
            UserEntity comparePasswordEntity = userRepository.findByID(new UserEntity(dto.getUserID(), dto.getPassword()));

            if(dto.getPassword().equals(comparePasswordEntity.getPassword())){
                planRepository.deletePlan(dto.getPlan());
                return true;
            }else {
                return false;
            }

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }

}
