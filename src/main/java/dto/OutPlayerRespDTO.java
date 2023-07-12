package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.Player.Player;
import model.outPlayer.OutPlayer;


@Getter @Setter @AllArgsConstructor
public class OutPlayerRespDTO {


    private Player player;
    private OutPlayer outPlayer;


    public void getAllOutPlayer() {
    }
    // 응답 : 야구장 목록은 Model -> Stadium을 List에 담아서 출력한다.
}
