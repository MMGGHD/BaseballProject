package model.stadium;

import db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StadiumDAO {

    private Connection connection;

    public StadiumDAO() {
        connection = DBConnection.getInstance();
    }

    public void StadiumInsert(String stadiumName) throws SQLException {
        String query = "INSERT INTO 야구장테이블명 (stadium_name, stadium_created_at) VALUES (?, now())";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, stadiumName);

            // 응답 : 성공이라는 메시지를 출력한다.
            System.out.println("응답 : 성공");
        }
    }

    public List<Stadium> getAllStadiums() throws SQLException {
        List<Stadium> stadiums = new ArrayList<Stadium>();
        String query = "SELECT * FROM 야구장테이블명";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Stadium stadium = buildStadiumFromResultSet(resultSet);
                    stadiums.add(stadium);
                }
            }
        }
        // 응답 : 야구장 목록은 Model -> Stadium을 List에 담아서 출력한다.
        return stadiums;
    }

    public Stadium buildStadiumFromResultSet(ResultSet rs) throws SQLException {
        int stadiumId = rs.getInt("stadium_id");
        String stadiumName = rs.getString("stadium_name");
        Timestamp stadiumCreatedAt = rs.getTimestamp("stadium_created_at");

        return Stadium.builder()
                .stadiumId(stadiumId)
                .stadiumName(stadiumName)
                .stadiumCreatedAt(stadiumCreatedAt)
                .build();

    }
}
