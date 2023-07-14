package service;

import model.Player.Player;
import model.Player.PlayerDAO;

import java.util.List;

public class PlayerService {

    private PlayerDAO playerDAO;

    public PlayerService() {
        playerDAO = new PlayerDAO();
    }

    //선수등록 기능
    public void playerInsertService (int teamId, String playerName, String position) throws Exception{
        playerDAO.playerInsert(teamId, playerName, position);
        System.out.println(teamId + playerName + position);
    }

    //팀별 선수목록 보기 기능
    public void getPlayerByTeamService(int teamId) {
        playerDAO.getPlayerByTeam(teamId);
    }
}