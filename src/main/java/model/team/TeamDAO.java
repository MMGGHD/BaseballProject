package model.team;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeamDAO {

    private Connection connection;

    public TeamDAO(){
        connection = DBConnection.getInstance();
    }

    public void teamInsert(int stadiumId, String teamName) {

        String query = "INSERT INTO team (id, name) VALUES (?, ?, now())";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, stadiumId);
            statement.setString(2, teamName);
            statement.executeUpdate();
            // 응답 : 성공이라는 메시지를 출력한다.
            System.out.println("응답 : 팀 등록 성공");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }



}
