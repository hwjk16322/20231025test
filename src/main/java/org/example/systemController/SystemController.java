package org.example.systemController;


import org.example.Container;
import org.example.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SystemController {
    Scanner sc = Container.getSc();
    List<User> userList = new ArrayList<>();
    public String loginID;

    public void sign() {
        if (loginID != null) {
            System.out.println("이미 로그인되어있습니다.");
            return;
        }
        String userId;
        String userPW;

        System.out.println("사용하실 아이디를 입력해주세요");
        System.out.println("취소하시려면 취소를 입력해주세요");
        while (true) {
            boolean idError = true;
            System.out.print("입력 ) ");
            userId = sc.nextLine();
            if (userId.equals("취소")) {
                break;
            }
            for (int i = 0; i < userList.size(); i++) {
                if (userId.equals(userList.get(i).getId())) {
                    System.out.println("이미 존재하는 아이디입니다. 다시 입력해주세요");
                    idError = false;
                }
            }
            if (idError) {
                break;
            }
        }
        if (userId.equals("취소")) {
            return;
        }
        System.out.println("사용하실 비밀번호를 입력해주세요.");
        while (true) {
            System.out.print("입력 ) ");
            userPW = sc.nextLine();
            System.out.println("비밀번호 확인");
            System.out.print("입력 ) ");
            String pwCheck = sc.nextLine();
            if (userPW.equals(pwCheck)) {
                System.out.println("회원가입이 완료되었습니다.");
                break;
            } else {
                System.out.println("비밀번호가 다릅니다. 다시 시도해주세요.");
            }


        }
        User newUser = new User(userId, userPW);
        userList.add(newUser);
    }

    public void login() {
        boolean loginError = true;
        if (loginID != null) {
            System.out.println("이미 로그인되어있습니다.");
            return;
        }

        System.out.println("아이디를 입력해주세요");
        System.out.print("입력 ) ");
        String enteredId = sc.nextLine();
        System.out.println("비밀번호를 입력해주세요");
        System.out.print("입력 ) ");
        String enteredPW = sc.nextLine();

        for (int i = 0; i < userList.size(); i++) {
            if (enteredId.equals(userList.get(i).getId()) && enteredPW.equals(userList.get(i).getPassword())) {
                loginID = enteredId;
                loginError = false;
            }
        }

        if (loginError) {
            System.out.println("회원정보가 없습니다. 다시 시도해주세요.");
        }


    }

    public void logout() {

        if (loginID == null) {
            System.out.println("로그인 정보가 없습니다.");
            return;
        }

        loginID = null;
        System.out.println("로그아웃이 완료되었습니다.");
    }


    public void plzLogin(String command) {

        System.out.println("로그인 해야 " + command + "할 수 있습니다.");
    }
}