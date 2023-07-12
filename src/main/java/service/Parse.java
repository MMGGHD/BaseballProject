package service;

public class Parse {


    String input;
    String kkk;

    public Parse(String input) {
        this.input = input;
        kkk = input.split("\\?")[0];
        System.out.println("input : "+input);
        System.out.println("("+kkk+" << 메서드 실행 )");
    }

//    void 야구장등록() {
//
//        String RegisterStadiumName;
//
//        System.out.println("야구장 등록 호출");
//        RegisterStadiumName = input.split("\\?")[1].split("name=")[1];
//        System.out.println("RegisterStadiumName: " + RegisterStadiumName);
//    }
//
//    void 야구장목록() {
//
//        System.out.println("야구장 목록 호출");
//
//    }
//
//    void 팀등록() {
//
//        int stadiumId;
//        String stadiumName;
//
//        System.out.println("------------------------");
//        System.out.println("팀등록 호출");
//        stadiumId = Integer.parseInt(input.split("\\?")[1].split("&")[0].split("stadiumId=")[1]);
//        stadiumName = input.split("&")[1].split("name=")[1];
//        System.out.println("stadiumId: " + stadiumId);
//        System.out.println("stadiumName: " + stadiumName);
//    }
//
//    void 팀목록() {
//
//        System.out.println("팀목록 호출");
//    }
//
//    void 선수등록() {
//
//        int teamId;
//        String playerName;
//        String position;
//
//        System.out.println("------------------------");
//        System.out.println("선수등록 호출");
//        teamId = Integer.parseInt(input.split("\\?")[1].split("&")[0].split("teamId=")[1]);
//        playerName = input.split("\\?")[1].split("&")[1].split("name=")[1];
//        position = input.split("\\?")[1].split("&")[2].split("position=")[1];
//        System.out.println("teamId: " + teamId);
//        System.out.println("playerName: " + playerName);
//        System.out.println("position: " + position);
//    }
//
//    void 선수목록() {
//
//        int searchTeamId;
//
//        System.out.println("------------------------");
//        System.out.println("팀별 선수목록 호출");
//        searchTeamId = Integer.parseInt((input.split("teamId=")[1]));
//        System.out.println("searchTeamId: " + searchTeamId);
//    }
//
//    void 퇴출등록() {
//
//        int outPlayerId;
//        String reason;
//
//        System.out.println("------------------------");
//        outPlayerId = Integer.parseInt(input.split("\\?")[1].split("&")[0].split("playerId=")[1]);
//        reason = input.split("&")[1].split("reason=")[1];
//        System.out.println("outPlayerId: " + outPlayerId);
//        System.out.println("reason: " + reason);
//    }
//
//    void 퇴출목록() {
//
//        System.out.println("퇴출선수목록 호출");
//    }
//
//    void 포지션별목록() {
//
//        System.out.println("포지션별 팀 페이지 호출");
//
//    }

}
