package jyplord.calender.Service;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import jyplord.calender.DTO.planningDTO;
import jyplord.calender.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
@RequiredArgsConstructor
public class CalendarService{
    private Connection connection;
    
    // 계획세우고 저장하기!
    public String savePlan(planningDTO dto) {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Calendar", "1234", "1234");
            String query = "INSERT INTO plans (user_id, plan, write_date) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, dto.getUserId());
            preparedStatement.setString(2, dto.getPlan());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(dto.getWriteDate()));

            int result = preparedStatement.executeUpdate();
            if(result >0){
                return "Plan saved Successfully";
            }else {
                return "Fail";
            }

        } catch (SQLException sqlError){
            sqlError.printStackTrace();
        }
        return "";
    }

    // 계획 불러오기
    public ArrayList<planningDTO> getPlanList(String userId, LocalDateTime writeDate, int paging){
        ArrayList<planningDTO> plans = new ArrayList<>();

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Calendar", "1234", "1234");

            // name 을 같이 조회하기 위한 user 테이블과 plan 테이블 조인 , 10개씩 페이징 처리
            String query =  "SELECT user_id, name , plan, write_date FROM plans INNER JOIN users ON user_id WHERE write_date = ?  AND user_id = ? LIMIT 10 OFFSET ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            //LocalDateTime 과 호환이 되지 않아 , Timestamp 로 변환
            preparedStatement.setTimestamp(1, Timestamp.valueOf(writeDate));
            preparedStatement.setString(2, userId);
            preparedStatement.setInt(3, paging);


            ResultSet getResult = preparedStatement.executeQuery();

            while(getResult.next()) {
                plans.add(new planningDTO(
                        getResult.getString("userId"),
                        getResult.getString("name"),
                        getResult.getString("plan"),
                        getResult.getTimestamp("write_date").toLocalDateTime()
                ));
            }

        }catch (SQLException sqlError){
            sqlError.printStackTrace();
        }
        return plans;
    }


    public ResponseEntity<String> revisePlan(planningDTO dto){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Calendar", "1234", "1234");

            // ID를 조건으로 비밀번호 조회.
            String securityQuery = "SELECT password FROM users WHERE userId = ? ";
            PreparedStatement comparePassword = connection.prepareStatement(securityQuery);
            comparePassword.setString(1, dto.getUserId());


            ResultSet db_password = comparePassword.executeQuery();

            // password 가 반환이 돼서 Next Cursor 가 있다면 아이디는 존재하는걸로 간주
            if(db_password.next()) {
                String a = db_password.getString("password");

                // password 동일성 검사
                if(a.equals(dto.getPassword())){
                    // 이름, 일정 조회
                    String reviseQuery = "UPDATE plans A INNER JOIN users B ON A.user_id = B.user_id SET B.name = ?, A.plan = ? ";
                    PreparedStatement revisedPlan = connection.prepareStatement(reviseQuery);

                    revisedPlan.setString(1, dto.getName());
                    revisedPlan.setString(2, dto.getPlan());
                    revisedPlan.executeUpdate();
                }else {
                    return new ResponseEntity<>("Invalid Password", HttpStatus.UNAUTHORIZED);
                }
            }else{
                 return new ResponseEntity<>("User not found", HttpStatus.UNAUTHORIZED);
            }


        } catch (SQLException sqlError){
            sqlError.printStackTrace();
        }
        return new ResponseEntity<>("revice complete.", HttpStatus.ACCEPTED);
    }
    public String deletePlan(planningDTO dto){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Calendar", "1234", "1234");

            String deleteQuery = "DELETE FROM plans WHERE plan_id = ?";
            PreparedStatement deletingPlan = connection.prepareStatement(deleteQuery);

            deletingPlan.setBigDecimal(1, dto.getPlan_id());
            deletingPlan.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        }
        return "";
    }

}
