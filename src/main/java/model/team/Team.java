package model.team;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter @AllArgsConstructor
public class Team {

    private int teamId; // PK
    private int stadiumId; // FK
    private String teamName;
    private Timestamp teamCreatedAt;

}
