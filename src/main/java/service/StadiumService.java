package service;

import model.stadium.Stadium;
import model.stadium.StadiumDAO;

import java.util.List;

public class StadiumService {
    private StadiumDAO stadiumDAO;

    public StadiumService() {
        StadiumDAO stadiumDAO = new StadiumDAO();

    }
    // 스타디움 등록기능
    public void stadiumInsertService(String stadiumName ){
        stadiumDAO.stadiumInsert(stadiumName);

    }

    // 스타디움 목록보기
    public void getAllStadiumsService(){
        stadiumDAO.getAllStadiums();
    }


}