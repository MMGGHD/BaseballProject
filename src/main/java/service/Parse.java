package service;

import dto.OutPlayerRespDTO;
import dto.PositionRespDto;
import dto.TeamRespDTO;
import model.Player.PlayerDAO;
import model.stadium.StadiumDAO;
import model.team.TeamDAO;

public class Parse {

    String request;
    String input;

    public Parse(String input) {
        this.input = input;
        request = input.split("\\?")[0];
        select();
    }

    public void output() {

        try{
            if (request.equals("야구장등록")) {
                String RegisterStadiumName;
                RegisterStadiumName = input.split("\\?")[1].split("name=")[1];
                StadiumDAO stadiumDAO = new StadiumDAO();
                stadiumDAO.stadiumInsert(RegisterStadiumName);
                System.out.println("야구장등록 성공");
            } else if (request.equals("야구장목록")) {
                StadiumDAO stadiumDAO = new StadiumDAO();
                stadiumDAO.getAllStadiums();
            } else if (request.equals("선수등록")){
                int teamId;
                String playerName;
                String position;
                teamId = Integer.parseInt(input.split("\\?")[1].split("&")[0].split("teamId=")[1]);
                playerName = input.split("\\?")[1].split("&")[1].split("name=")[1];
                position = input.split("\\?")[1].split("&")[2].split("position=")[1];
                PlayerDAO playerDAO = new PlayerDAO();
                playerDAO.playerInsert(teamId, playerName, position);
                System.out.println("선수등록 성공");
            } else if(request.equals("팀등록")) {
                int stadiumId;
                String stadiumName;
                stadiumId = Integer.parseInt(input.split("\\?")[1].split("&")[0].split("stadiumId=")[1]);
                stadiumName = input.split("&")[1].split("name=")[1];
                TeamDAO teamDAO = new TeamDAO();
                teamDAO.teamInsert(stadiumId, stadiumName);
            } else if(request.equals("팀목록")){
                TeamDAO teamDAO = new TeamDAO();
                teamDAO.getAllTeam();
            }
            else if (request.equals("선수목록")){
                int searchTeamId;
                searchTeamId = Integer.parseInt((input.split("teamId=")[1]));
                PlayerDAO playerDAO = new PlayerDAO();
                playerDAO.getPlayerByTeam(searchTeamId);
            } else if (request.equals("퇴출등록")){
                int outPlayerId;
                String reason;
                outPlayerId = Integer.parseInt(input.split("\\?")[1].split("&")[0].split("playerId=")[1]);
                reason = input.split("&")[1].split("reason=")[1];
                OutPlayerService outPlayerService = new OutPlayerService(outPlayerId, reason);
                System.out.println("퇴출등록 성공");
            } else if (request.equals("퇴출목록")){
                OutPlayerRespDTO outPlayerRespDTO = new OutPlayerRespDTO();
                outPlayerRespDTO.getAllOutPlayer();
            } else if (request.equals("포지션별목록")){
                PositionRespDto positionRespDto = new PositionRespDto();
                positionRespDto.getPositionResp();
            }
            else {
                System.out.println("잘못된 요청입니다.");
            }
        }
        catch(Exception e) {
            System.out.println("잘못된 명령어입니다.");

        }
        new Service();
    }

    public void exit(){
        System.out.println("종료되었습니다.");
    }
    public void select(){
        if(request.equals("종료")){
            exit();
        }
        else {
            output();

        }


    }
}