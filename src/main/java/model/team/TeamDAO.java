package model.team;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class TeamDAO {

    private Connection connection;

    public TeamDAO(){
        connection = DBConnection.getInstance();
    }

    public void teamInsert(int stadiumId, String teamName) throws SQLException {

        String query = "INSERT INTO 팀테이블명 (stadium_id, team_name) VALUES (?, ?, now())";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, stadiumId);
            statement.setString(2, teamName);

            // 응답 : 성공이라는 메시지를 출력한다.
            System.out.println("응답 : 성공");
        }

    }



}
