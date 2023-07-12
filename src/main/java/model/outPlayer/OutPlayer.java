package model.outPlayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter @AllArgsConstructor
public class OutPlayer {

    private int outPlayerId; // PK
    private int playerId; // FK
    private String reason;
    private Timestamp outPlayerCreatedAt;
}
