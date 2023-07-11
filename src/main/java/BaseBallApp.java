import model.outPlayer.OutPlayerDAO;
import model.stadium.StadiumDAO;

public class BaseBallApp {


    public static void main(String[] args) {
//        DBConnection.getInstance();

//        Scanner sc = new Scanner(System.in);
//        System.out.println("어떤 기능을 요청하시겠습니까?");
//        String request = sc.nextLine();
//        System.out.println(request);

        OutPlayerDAO sdo = new OutPlayerDAO();
        sdo.outPlayerInsert(13,"머리 안감음");
    }
}
