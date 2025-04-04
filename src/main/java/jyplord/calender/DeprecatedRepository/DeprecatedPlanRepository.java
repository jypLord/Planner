package jyplord.calender.Repository;

import jyplord.calender.DTO.request.SaveRequest;
import jyplord.calender.DTO.response.AllPlanResponse;
import jyplord.calender.Entity.PlanEntity;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DeprecatedPlanRepository {
    /*
    private Connection connection;


    public List<AllPlanResponse> findByID(PlanEntity entity, int page) throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Calendar", "1234", "1234");

        // name 을 같이 조회하기 위한 user 테이블과 plan 테이블 조인 , 10개씩 페이징 처리
        String query = "SELECT A.user_id, B.name , A.plan, A.write_date FROM plans A INNER JOIN users B ON A.user_id = B.user_id WHERE A.write_date = ?  AND A.user_id = ? LIMIT 10 OFFSET ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        //LocalDateTime 과 호환이 되지 않아 , Timestamp 로 변환
        preparedStatement.setTimestamp(1, Timestamp.valueOf(entity.getWriteDate()));
        preparedStatement.setString(2, entity.getUserID());
        preparedStatement.setInt(3, page);

        ResultSet getResult = preparedStatement.executeQuery();

        List<AllPlanResponse> planList = new ArrayList<>();

        while (getResult.next()) {
            planList.add(new AllPlanResponse(
                    getResult.getString("user_id"),
                    getResult.getString("name"),
                    getResult.getString("plan"),
                    getResult.getTimestamp("write_date").toLocalDateTime()
            ));

        }
    return planList;
    }
    public void revisePlan(String name , String plan)throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Calendar", "1234", "1234");
        // 이름, 일정 조회
        String reviseQuery = "UPDATE plans A INNER JOIN users B ON A.user_id = B.user_id SET B.name = ?, A.plan = ? WHERE A.plan=?";
        PreparedStatement revisedPlan = connection.prepareStatement(reviseQuery);

        revisedPlan.setString(1, name);
        revisedPlan.setString(2, plan);
        revisedPlan.setString(3, plan);
        revisedPlan.executeUpdate();
    }
    public void deletePlan(String plan) throws SQLException{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Calendar", "1234", "1234");

        String deleteQuery = "DELETE FROM plans WHERE plan = ?";
        PreparedStatement deletingPlan = connection.prepareStatement(deleteQuery);

        deletingPlan.setString(1, plan);
        deletingPlan.executeUpdate();
    }

    public void savePlan(SaveRequest dto) throws SQLException{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Calendar", "1234", "1234");
        String query = "INSERT INTO plans (user_id, plan, write_date) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, dto.getUserID());
        preparedStatement.setString(2, dto.getPlan());
        preparedStatement.setTimestamp(3, Timestamp.valueOf(dto.getWriteDate()));

        preparedStatement.executeUpdate();
    }
*/
}

