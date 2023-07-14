package dto;

import db.DBConnection;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PositionRespDto {


    private Connection connection;
    private String position;
    private String team1;
    private String team2;
    private String team3;

    public PositionRespDto() {
        connection = DBConnection.getInstance();
    }

    @Builder
    public PositionRespDto(String position, String team1, String team2, String team3) {
        this.position = position;
        this.team1 = team1;
        this.team2 = team2;
        this.team3 = team3;
    }

    public void getPositionResp() {
        List<PositionRespDto> positionResps = new ArrayList<PositionRespDto>();
        String query = "select \n" +
                "pr.position '포지션',\n" +
                "MAX(if(tm.id = 1, pr.name, null)) '롯데',\n" +
                "MAX(if(tm.id = 2, pr.name, null)) 'SK',\n" +
                "MAX(if(tm.id = 3, pr.name, null)) 'NC'\n" +
                "from player pr\n" +
                "left outer join team tm on pr.team_id = tm.id\n" +
                "group by pr.position";
        try (
                PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    PositionRespDto positionRespDto = buildPositionRespsFromResultSet(resultSet);
                    positionResps.add(positionRespDto);
                }
            }
        } catch (
                SQLException e) {
            System.out.println("SQL을 적용하는데 문제가 발생했습니다.");
            e.printStackTrace();
        }


        System.out.println("---------- 포지션별 팀 선수 -------------------");
        System.out.println("포지션   롯데   SK   NC");
        for (PositionRespDto positionRespDto : positionResps) {
            System.out.println(
                    positionRespDto.getPosition() + ": "
                            + positionRespDto.getTeam1() + ", "
                            + positionRespDto.getTeam2() + ", "
                            + positionRespDto.getTeam3());
        }
    }

    public PositionRespDto buildPositionRespsFromResultSet(ResultSet rs) throws SQLException {
        String position = rs.getString("포지션");
        String team1 = rs.getString("롯데");
        String team2 = rs.getString("SK");
        String team3 = rs.getString("NC");

        return PositionRespDto.builder()
                .position(position)
                .team1(team1)
                .team2(team2)
                .team3(team3)
                .build();
    }
}
