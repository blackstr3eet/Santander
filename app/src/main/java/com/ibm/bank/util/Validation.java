package com.ibm.bank.util;

public class Validation {

    private static final String LOGIN_USER_REGEX = "^(\\d{11}$)|((\\D+)([@])((.*\\.com)|(.*\\.com.br)))$";
    private static final String LOGIN_PASSWORD_REGEX = "((?=.*[0-9])|(?=.*[a-z]))(?=.*[A-Z])(?=.*[$*&@#])[a-z0-9A-Z$*&@#]{3,}";

    public static  boolean checkUserLogin(String user) {
        return user.matches(LOGIN_USER_REGEX);
    }

    public static boolean checkPasswordLogin(String user) {
        return user.matches(LOGIN_PASSWORD_REGEX);
    }
}