package jyplord.calender.Repository;

import jyplord.calender.DTO.DTO;
import jyplord.calender.DTO.planningDTO;
import jyplord.calender.Entity.PlanEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanRepository {
    private Connection connection;
    List<PlanEntity> plans = new ArrayList<>();

    List<PlanEntity> findByID(DTO planRequest) throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Calendar", "1234", "1234");

        // name 을 같이 조회하기 위한 user 테이블과 plan 테이블 조인 , 10개씩 페이징 처리
        String query =  "SELECT user_id, name , plan, write_date FROM plans INNER JOIN users ON user_id WHERE write_date = ?  AND user_id = ? LIMIT 10 OFFSET ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        //LocalDateTime 과 호환이 되지 않아 , Timestamp 로 변환
        preparedStatement.setTimestamp(1, Timestamp.valueOf(planRequest.getWriteDate));
        preparedStatement.setString(2, planRequest.getUserId);
        preparedStatement.setInt(3, planRequest.getPage);

        ResultSet getResult = preparedStatement.executeQuery();

        while(getResult.next()) {
            plans.add(new planningDTO(
                    getResult.getString("userId"),
                    getResult.getString("name"),
                    getResult.getString("plan"),
                    getResult.getTimestamp("write_date").toLocalDateTime()
            ));


    }
}



