package service;

import java.util.Scanner;

public class Service {

    public Service() {
        Scanner sc = new Scanner(System.in);
        System.out.print("명령어를 입력하세요: ");
        String input = sc.nextLine();
        System.out.println(input + "을 입력하셨습니다");
        new Parse(input);
    }
}
