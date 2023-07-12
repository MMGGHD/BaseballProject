package model.Player;

import db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {


    private Connection connection;

    public PlayerDAO() {
        connection = DBConnection.getInstance();
    }

    public void playerInsert(int teamId, String playerName, String position) {

        String query = "INSERT INTO player (team_id, name, position, created_at) VALUES (?, ?, ?, now())";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, teamId);
            statement.setString(2, playerName);
            statement.setString(3, position);
            statement.executeUpdate();
            // 응답 : 성공이라는 메시지를 출력한다.
            System.out.println("응답 : 성공");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void updatePlayer(int playerId) {
        String query = "Update player Set team_id = null Where id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, playerId);
            statement.executeUpdate();
            System.out.println("응답 : 성공");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Player> getPlayerByTeam(int teamId) {

        List<Player> players = new ArrayList<>();
        String query = "SELECT id, name, position, created_at FROM player where team_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, teamId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Player player = buildPlayerFromResultSet(resultSet);
                    players.add(player);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return players;
    }
    // 응답 : 선수 목록은 Model -> Player를 List에 담아서 출력한다. (team_id는 출력하지 않아도 된다)


    public Player buildPlayerFromResultSet(ResultSet rs) throws SQLException {
        int playerId = rs.getInt("id");
        String playerName = rs.getString("name");
        String position = rs.getString("position");
        Timestamp playerCreatedAt = rs.getTimestamp("created_at");

        return Player.builder()
                .playerId(playerId)
                .playerName(playerName)
                .position(position)
                .playerCreatedAt(playerCreatedAt)
                .build();


    }

}

