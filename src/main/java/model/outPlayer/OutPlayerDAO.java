package model.outPlayer;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class OutPlayerDAO {
    private Connection connection;

    public OutPlayerDAO(){
        connection = DBConnection.getInstance();
    }

    public void outPlayerInsert() {
    }
    // 응답 : 성공이라는 메시지를 출력한다.
    public void outPlayerInsert(int playerId, String reason) throws SQLException {

        String query = "INSERT INTO 퇴출선수테이블명 (player_id, reason) VALUES (?, ?, now())";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, playerId);
            statement.setString(2, reason);

            // 응답 : 성공이라는 메시지를 출력한다.
            System.out.println("응답 : 성공");
        }

    }
}
