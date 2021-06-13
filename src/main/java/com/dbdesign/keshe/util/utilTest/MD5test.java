package com.dbdesign.keshe.util.utilTest;

import com.dbdesign.keshe.util.MD5;

import java.util.Scanner;

public class MD5test {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String test = scanner.nextLine();
        String MD5String = MD5.crypt(test);
        System.out.println(MD5String);
    }
}
