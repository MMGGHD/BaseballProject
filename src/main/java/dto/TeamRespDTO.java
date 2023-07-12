package dto;

import db.DBConnection;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Getter @Setter
public class TeamRespDTO {

    private Connection connection;

    private String teamName;
    private String stadiumName;

    public TeamRespDTO() {
        connection = DBConnection.getInstance();
    }
    @Builder
    public TeamRespDTO(String teamName, String stadiumName){
        this.teamName = teamName;
        this.stadiumName = stadiumName;
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
        for (TeamRespDTO teamRespDTO: teams)
             {
                 System.out.println(teamRespDTO.getTeamName()+"의 경기장 : "+teamRespDTO.getStadiumName());
        }
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
