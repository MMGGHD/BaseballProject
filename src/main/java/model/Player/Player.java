package model.Player;

import lombok.Getter;

import java.sql.Timestamp;

public class Player {

    @Getter
    private int playerId; // PK
    private int teamId; // FK
    private String playerName;
    private String position;
    private Timestamp playerCreatedAt;
}
