package org.example;


import org.example.postService.AppController;
import org.example.userService.UserController;

import java.util.Scanner;

public class App {
    public void run() {
        Scanner sc = Container.getSc();
        AppController appController = new AppController();
        UserController systemController = new UserController();
        boolean sayHello = true;


        System.out.println("== 텍스트 게시판 ==");

        while (true) {
            String loginID = systemController.loginID;
            if (loginID == null) {
                sayHello = true;
            }

            if (loginID != null && sayHello) {
                System.out.println(loginID + "님 안녕하세요!");
                sayHello = false;
            }

            System.out.println("\n명령어) 등록,목록,수정,삭제,회원가입,로그인,로그아웃,종료");
            System.out.print("입력 ) ");
            String command = sc.nextLine();

            switch (command) {
                case "등록":
                    if (loginID == null) {
                        systemController.plzLogin(command);
                        break;
                    }

                    appController.write(loginID);
                    break;

                case "목록":
                    appController.list();
                    break;

                case "수정":
                    if (loginID == null) {
                        systemController.plzLogin(command);
                        break;
                    }

                    appController.modify(loginID);
                    break;

                case "삭제":
                    if (loginID == null) {
                        systemController.plzLogin(command);
                        break;
                    }

                    appController.remove(loginID);
                    break;

                case "회원가입":
                    systemController.sign();
                    break;

                case "로그인":
                    systemController.login();
                    break;

                case "로그아웃":
                    systemController.logout();
                    break;

                case "종료":
                    System.out.println("앱을 종료합니다..");
                    return;

            }


        }
    }
}
