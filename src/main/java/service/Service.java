package service;

import java.util.Scanner;

public class Service {

    public Service() {
        System.out.println("");
        System.out.println("어떤기능을 요청하시겠습니까?");
        System.out.print("종료하시려면 '종료'를 입력하세요 : ");
        String input = new Scanner(System.in).nextLine();
        System.out.println(input + "을 입력하셨습니다");
        new Parse(input);
    }


}