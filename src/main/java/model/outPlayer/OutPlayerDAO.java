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
    public void outPlayerInsert(int playerId, String reason) {

        String query = "INSERT INTO out_player (player_id, reason, created_at) VALUES (?, ?, now())";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, playerId);
            statement.setString(2, reason);
            statement.executeUpdate();
            // 응답 : 성공이라는 메시지를 출력한다.
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void updatePlayer(int playerId) {
        String query = "Update player Set team_id = null Where id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, playerId);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
