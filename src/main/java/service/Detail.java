package service;

public class Detail {

    public Detail() {
        System.out.println("");
        System.out.println("");
        System.out.println("어떤기능을 요청하시겠습니까?");
        System.out.println("1. 야구장등록 [예시 : 야구장등록?name=잠실야구장]");
        System.out.println("2. 전체 야구장 목록보기 [예시 : 야구장목록]");
        System.out.println("3. 팀 등록 [예시 : 팀등록?stadiumId=1&name=NC]");
        System.out.println("4. 전체 팀 목록 [예시 : 팀목록]");
        System.out.println("5. 선수등록 [예시 : 선수등록?teamId=1&name=이대호&position=1루수");
        System.out.println("6. 팀별 선수 목록 [예시 : 선수목록?teamId=1]");
        System.out.println("7. 선수 퇴출 등록 [예시 : 퇴출등록?playerId=1&reason=도박]");
        System.out.println("8. 선수 퇴출 목록 [예시 : 퇴출목록]");
        System.out.println("9. 포지션별 팀 야구 선수 페이지 [예시 : 포지션별목록]");


    }
}