package model.stadium;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

public class Stadium {

    @Getter
    private int stadiumId; // PK
    private String stadiumName;
    private Timestamp stadiumCreatedAt;

    @Builder
    public Stadium(int stadiumId, String stadiumName, Timestamp stadiumCreatedAt) {
        this.stadiumId = stadiumId;
        this.stadiumName = stadiumName;
        this.stadiumCreatedAt = stadiumCreatedAt;
    }
}
