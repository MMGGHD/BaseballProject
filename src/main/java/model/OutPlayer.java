package model;

import java.sql.Timestamp;

public class OutPlayer {

    private int outPlayerId; // PK
    private int playerId; // FK
    private String reason;
    private Timestamp outPlayerCreatedAt;
}
