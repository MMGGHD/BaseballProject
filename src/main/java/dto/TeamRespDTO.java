package dto;

import db.DBConnection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.stadium.Stadium;
import model.team.Team;
import model.team.TeamDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Getter @Setter
public class TeamRespDTO {

    private Connection connection;
    private Team team;
    private Stadium stadium;

    public  TeamRespDTO(){
        connection = DBConnection.getInstance();

    public List<TeamRespDTO> getAllTeam() {
//
//        List<TeamRespDTO> teams = new ArrayList<TeamRespDTO>();
//        String query = "select\n" +
//                "tm.name '구단명',\n" +
//                "sm.name '경기장'\n" +
//                "from team tm\n" +
//                "left outer join stadium sm on tm.id = sm.id;";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            try (ResultSet resultSet = statement.executeQuery()) {
//                while (resultSet.next()) {
//                    Teams teams = buildStadiumFromResultSet(resultSet);
//                    teams.add(stadium);
//                }
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
        }
        // 응답 : 야구장 목록은 Model -> Stadium을 List에 담아서 출력한다.
        return teams;
    }

}
    // 응답 : 팀 목록은 Stadium 정보를 조인해서 출력해야 된다. TeamRespDTO가 필요하다.
}
