package service;


import model.Player.Player;
import model.Player.PlayerDAO;
import model.outPlayer.OutPlayerDAO;

public class OutPlayerService {

    //OutplayerService (Insert, update) 기능
    public OutPlayerService(int playerID, String reason) {


        OutPlayerDAO op = new OutPlayerDAO();
        op.outPlayerInsert(playerID, reason);

        PlayerDAO pr = new PlayerDAO();
        pr.updatePlayer(playerID);

        System.out.println("성공");



    }
}