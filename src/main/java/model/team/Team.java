package model.team;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter @AllArgsConstructor
public class Team {

    private int teamId; // PK
    private int stadiumId; // FK
    private String teamName;
    private Timestamp teamCreatedAt;

}
