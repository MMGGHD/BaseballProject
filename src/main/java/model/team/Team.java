package model.team;

import lombok.Getter;

import java.sql.Timestamp;

public class Team {

    @Getter
    private int teamId; // PK
    private int stadiumId; // FK
    private String teamName;
    private Timestamp teamCreatedAt;

}
