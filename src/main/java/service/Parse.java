package service;

import dto.OutPlayerRespDTO;
import dto.PositionRespDto;
import model.Player.PlayerDAO;
import model.stadium.StadiumDAO;

public class Parse {

    String kkk;
    String input;

    public Parse(String input) {
        this.input = input;
        kkk = input.split("\\?")[0];
        System.out.println("input : " + input);
        System.out.println("(" + kkk + " << 메서드 실행 )");
    }

    public void output() {

        if (kkk == "야구장등록") {
            String RegisterStadiumName;
            RegisterStadiumName = input.split("\\?")[1].split("name=")[1];
            StadiumDAO stadiumDAO = new StadiumDAO();
            stadiumDAO.StadiumInsert(RegisterStadiumName);
            System.out.println("야구장등록 성공");
        } else if (kkk == "야구장목록") {
            System.out.println("-------------- 야구장 목록 -------------------");
            StadiumDAO stadiumDAO = new StadiumDAO();
            stadiumDAO.getAllStadiums();
        } else if (kkk == "선수등록") {
            int teamId;
            String playerName;
            String position;
            teamId = Integer.parseInt(input.split("\\?")[1].split("&")[0].split("teamId=")[1]);
            playerName = input.split("\\?")[1].split("&")[1].split("name=")[1];
            position = input.split("\\?")[1].split("&")[2].split("position=")[1];
            PlayerDAO playerDAO = new PlayerDAO();
            playerDAO.playerInsert(teamId, playerName, position);
            System.out.println("선수등록 성공");
        } else if (kkk == "선수목록") {
            int searchTeamId;
            searchTeamId = Integer.parseInt((input.split("teamId=")[1]));
            System.out.println("-------------- 팀별 선수목록 -------------------");
            PlayerDAO playerDAO = new PlayerDAO();
            playerDAO.getPlayerByTeam(searchTeamId);
        } else if (kkk == "퇴출등록") {
            int outPlayerId;
            String reason;
            outPlayerId = Integer.parseInt(input.split("\\?")[1].split("&")[0].split("playerId=")[1]);
            reason = input.split("&")[1].split("reason=")[1];
            OutPlayerService outPlayerService = new OutPlayerService(outPlayerId, reason);
            System.out.println("퇴출등록 성공");
        } else if (kkk == "퇴출목록") {
            System.out.println("-------------- 퇴출목록 -------------------");
            OutPlayerRespDTO outPlayerRespDTO = new OutPlayerRespDTO();
            outPlayerRespDTO.getAllOutPlayer();
        } else if (kkk == "포지션별목록") {
            System.out.println("-------------- 포지션별 목록 -------------------");
            PositionRespDto positionRespDto = new PositionRespDto();
            positionRespDto.getPositionResp();
        }
    }


}
