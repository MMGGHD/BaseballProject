package model.Player;

import db.DBConnection;
import model.stadium.Stadium;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {


    private Connection connection;

    public PlayerDAO() {
        connection = DBConnection.getInstance();
    }

    public void playerInsert(int teamId, String playerName, String position) throws SQLException {

        String query = "INSERT INTO 선수테이블명 (team_id, player_name, position) VALUES (?, ?, ?, now())";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, teamId);
            statement.setString(2, playerName);
            statement.setString(3, position);

            // 응답 : 성공이라는 메시지를 출력한다.
            System.out.println("응답 : 성공");
        }

    }

    public void updatePlayer() throws SQLException {
        String query = "UPDATE 선수테이블명 SET team_id = null";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        }
    }

    public List<Player> getPlayerByTeam(int teamId) throws SQLException {

        List<Player> players = new ArrayList<>();
        String query = "SELECT * FROM 플레이어 테이블명 where team_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, teamId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Player player = buildPlayerFromResultSet(resultSet);
                    players.add(player);
                }
            }
        }
        return players;
    }
    // 응답 : 선수 목록은 Model -> Player를 List에 담아서 출력한다. (team_id는 출력하지 않아도 된다)


    public Player buildPlayerFromResultSet(ResultSet rs) throws SQLException {
        int playerId = rs.getInt("player_id");
        String playerName = rs.getString("player_name");
        String position = rs.getString("position");
        Timestamp playerCreatedAt = rs.getTimestamp("player_created_at");

        return Player.builder()
                .playerId(playerId)
                .playerName(playerName)
                .position(position)
                .playerCreatedAt(playerCreatedAt)
                .build();


    }

}

