package model.Player;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

public class Player {

    @Getter
    private int playerId; // PK
    private int teamId; // FK
    private String playerName;
    private String position;
    private Timestamp playerCreatedAt;

    @Builder
    public Player(int playerId, String playerName, String position, Timestamp playerCreatedAt){
        this.playerId = playerId;
        this.playerName = playerName;
        this.position = position;
        this.playerCreatedAt = playerCreatedAt;
    }
}
