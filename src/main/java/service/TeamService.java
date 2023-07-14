package service;

import dto.TeamRespDTO;
import model.team.TeamDAO;

public class TeamService {
    private TeamDAO teamDAO;
    private TeamRespDTO teamRespDTO;

    public TeamService() {
        teamDAO = new TeamDAO();
        teamRespDTO = new TeamRespDTO();
    }

    // 팀 등록 기능
    public void teamInsertService(int stadiumId, String teamName) {
        teamDAO.teamInsert(stadiumId, teamName);
    }

    // 팀 전체목록 보기 기능
    public void getAllTeamListService() {
        teamDAO.getAllTeam();
    }


}