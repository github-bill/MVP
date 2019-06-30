package com.bill.mvp.model;

import android.text.TextUtils;

public class LoginModel implements ILoginModel {
    private static final String USER_NAME = "hxb";
    private static final String PASSWORD = "123";

    public LoginModel() {
    }


    @Override
    public boolean checkValidity(String userName, String password) {
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password) || !USER_NAME.equalsIgnoreCase(userName) || !PASSWORD.equalsIgnoreCase(password)) {
            return false;
        }
        return true;

    }
}
