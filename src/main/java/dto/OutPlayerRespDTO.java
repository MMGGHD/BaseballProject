package dto;

import db.DBConnection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import model.Player.Player;
import model.outPlayer.OutPlayer;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class OutPlayerRespDTO {

    private Connection connection;
    private String playerId;
    private String playerName;
    private String position;
    private String reason;
    private Timestamp outPlayerCreatedAt;

    public OutPlayerRespDTO() {
        connection = DBConnection.getInstance();
    }

    @Builder
    public OutPlayerRespDTO(String playerId, String playerName, String position, String reason, Timestamp outPlayerCreatedAt) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.position = position;
        this.reason = reason;
        this.outPlayerCreatedAt = outPlayerCreatedAt;
    }

    public void getAllOutPlayer() {

        List<OutPlayerRespDTO> outPlayers = new ArrayList<OutPlayerRespDTO>();
        String query = "select \n" +
                "pr.id p_id,\n" +
                "pr.name p_name,\n" +
                "pr.position p_position,\n" +
                "op.reason o_reason,\n" +
                "op.created_at o_day\n" +
                "from player pr\n" +
                "left outer join  out_player op on op.player_id = pr.id";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    OutPlayerRespDTO outPlayerRespDTO = buildAllOutPlayerFromResultSet(resultSet);
                    outPlayers.add(outPlayerRespDTO);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL을 적용하는데 문제가 발생했습니다.");
            e.printStackTrace();
        }


        System.out.println("---------- 퇴출 선수 목록 -------------------");
        System.out.println("p.id   p.name   p.position   o.reason     o.day");
        for (OutPlayerRespDTO outPlayerRespDTO : outPlayers) {

//            String originalDateTime = outPlayerRespDTO.getOutPlayerCreatedAt().toString();
//            LocalDateTime dateTime = LocalDateTime.parse(originalDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
//            String formattedDateTime = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            System.out.println(
                    outPlayerRespDTO.getPlayerId() + "      "
                            + outPlayerRespDTO.getPlayerName() + "      "
                            + outPlayerRespDTO.getPosition() + "      "
                            + outPlayerRespDTO.getReason() + "      "
//                            + formattedDateTime);
                            + outPlayerRespDTO.getOutPlayerCreatedAt());



        }
    }

    public OutPlayerRespDTO buildAllOutPlayerFromResultSet(ResultSet rs) throws SQLException {
        String playerId = rs.getString("p_id");
        String playerName = rs.getString("p_name");
        String position = rs.getString("p_position");
        String reason = rs.getString("o_reason");
        Timestamp outPlayerCreatedAt = rs.getTimestamp("o_day");

        return OutPlayerRespDTO.builder()
                .playerId(playerId)
                .playerName(playerName)
                .position(position)
                .reason(reason)
                .outPlayerCreatedAt(outPlayerCreatedAt)
                .build();
    }
}

