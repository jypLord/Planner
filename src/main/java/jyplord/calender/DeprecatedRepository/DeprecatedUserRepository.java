package jyplord.calender.Repository;

import jyplord.calender.Entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class DeprecatedUserRepository {
    /*
    private Connection connection;

    public UserEntity findByID(UserEntity entity) throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Calendar", "1234", "1234");

        // 사용자가 만든 ID를 조건으로 비밀번호, 일련번호 ID 조회
        String query = "SELECT * FROM users WHERE userId = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, entity.getUserID());

        ResultSet user = preparedStatement.executeQuery();

        return new UserEntity(user.getInt("id"),
                user.getString("user_id"),
                user.getString("name"),
                user.getString("password"),
                user.getString("email"));

    }

    public void signUp(UserEntity entity) throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Calendar", "1234", "1234");

        String query = "INSERT INTO users (userID, name, password, email) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, entity.getUserID());
        preparedStatement.setString(2, entity.getName());
        preparedStatement.setString(3, entity.getUserID());
        preparedStatement.setString(4, entity.getEmail());

        preparedStatement.executeUpdate();
    }
    */
}
