package model.stadium;

import db.DBConnection;
import dto.TeamRespDTO;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StadiumDAO {

    private Connection connection;

    public StadiumDAO() {
        connection = DBConnection.getInstance();
    }

    public void stadiumInsert(String stadiumName) {

        String query = "INSERT INTO stadium (name, created_at) VALUES (?, now())";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, stadiumName);
            statement.executeUpdate();
            // 응답 : 성공이라는 메시지를 출력한다.
            System.out.println("응답 : 야구장 등록 성공");
        }
        catch (SQLException e){
            System.out.println("SQL을 적용하는데 문제가 발생했습니다.");
            e.printStackTrace();
        }
    }


    public void getAllStadiums() {
        List<Stadium> stadiums = new ArrayList<Stadium>();
        String query = "SELECT * FROM stadium";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Stadium stadium = buildStadiumFromResultSet(resultSet);
                    stadiums.add(stadium);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        // 응답 : 야구장 목록은 Model -> Stadium을 List에 담아서 출력한다.
        System.out.println("-------------- 전체 야구장 목록 -------------------");
        for (Stadium stadium: stadiums)
        {

            String originalDateTime = stadium.getStadiumCreatedAt().toString();
            LocalDateTime dateTime = LocalDateTime.parse(originalDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
            String formattedDateTime = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            System.out.println(stadium.getStadiumId()+"번 경기장 : "+stadium.getStadiumName()+"(연도: "+formattedDateTime+")");
        }
    }

    public Stadium buildStadiumFromResultSet(ResultSet rs) throws SQLException {
        int stadiumId = rs.getInt("id");
        String stadiumName = rs.getString("name");
        Timestamp stadiumCreatedAt = rs.getTimestamp("created_at");

        return Stadium.builder()
                .stadiumId(stadiumId)
                .stadiumName(stadiumName)
                .stadiumCreatedAt(stadiumCreatedAt)
                .build();

    }
}
