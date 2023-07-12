import dto.OutPlayerRespDTO;
import dto.PositionRespDto;
import dto.TeamRespDTO;
import model.outPlayer.OutPlayerDAO;
import model.stadium.StadiumDAO;

public class BaseBallApp {


    public static void main(String[] args) {
//        DBConnection.getInstance();

//        Scanner sc = new Scanner(System.in);
//        System.out.println("어떤 기능을 요청하시겠습니까?");
//        String request = sc.nextLine();
//        System.out.println(request);

        OutPlayerRespDTO dto = new OutPlayerRespDTO();
        dto.getAllOutPlayer();

        TeamRespDTO tdto = new TeamRespDTO();
        tdto.getAllTeam();

        PositionRespDto pdto = new PositionRespDto();
        pdto.getPositionResp();
    }
}
