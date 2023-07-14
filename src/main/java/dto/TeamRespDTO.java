package dto;

import db.DBConnection;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Getter @Setter
public class TeamRespDTO {

    private Connection connection;

    private String teamName;
    private String stadiumName;

    public TeamRespDTO() {
        connection = DBConnection.getInstance();
    }
    @Builder
    public TeamRespDTO(String teamName, String stadiumName){
        this.teamName = teamName;
        this.stadiumName = stadiumName;
    }



}
