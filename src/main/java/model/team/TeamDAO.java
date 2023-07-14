package model.team;

import db.DBConnection;
import dto.TeamRespDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamDAO {

    private Connection connection;

    public TeamDAO(){
        connection = DBConnection.getInstance();
    }

    public void teamInsert(int stadiumId, String teamName) {

        String query = "INSERT INTO team (stadium_id, name, created_at) VALUES (?, ?, now())";
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
    public void getAllTeam() {

        List<TeamRespDTO> teams = new ArrayList<TeamRespDTO>();
        String query = "select\n" +
                "tm.name '구단명',\n" +
                "sm.name '경기장'\n" +
                "from team tm\n" +
                "left outer join stadium sm on tm.id = sm.id;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    TeamRespDTO teamRespDTO = buildAllTeamFromResultSet(resultSet);
                    teams.add(teamRespDTO);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL을 적용하는데 문제가 발생했습니다.");
            e.printStackTrace();
        }
        // 응답 : 팀 목록은 Stadium 정보를 조인해서 출력해야 된다. TeamRespDTO가 필요하다.
        System.out.println("");
        System.out.println("--[팀목록]-----[홈그라운드]--");

        teams.forEach(teamRespDTO ->
                System.out.println(teamRespDTO.getTeamName()+" : "+teamRespDTO.getStadiumName()));

//        for (TeamRespDTO teamRespDTO: teams)
//        {
//            System.out.println(teamRespDTO.getTeamName()+" : "+teamRespDTO.getStadiumName());
//        }
    }

    public TeamRespDTO buildAllTeamFromResultSet(ResultSet rs) throws SQLException{
        String teamName = rs.getString("구단명");
        String stadiumName = rs.getString("경기장");

        return TeamRespDTO.builder()
                .teamName(teamName)
                .stadiumName(stadiumName)
                .build();
    }
}
