package com.bill.mvp.presenter;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.bill.mvp.model.ILoginModel;
import com.bill.mvp.model.LoginModel;
import com.bill.mvp.view.ILoginView;

public class LoginPresenter implements ILoginPresenter {
    private ILoginView iLoginView;
    private ILoginModel iLoginModel;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        iLoginModel = new LoginModel();
    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLogin(String userName, String password) {
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            iLoginView.showToast("您输入的密码或者账号有误，请重新输入");
            return;
        }

        iLoginView.showProgressBar();

        int i=0;

        try{

        }catch (Exception e){

        }

        if (true){

        }else {

        }

        Object obj=null;
        if (obj.toString().equalsIgnoreCase("")){

        }


        final boolean isLoginSuccess = iLoginModel.checkValidity(userName, password);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.hideProgressBar();
                if (isLoginSuccess) {
                    iLoginView.showToast("登录成功，欢迎使用MVP");
                } else {
                    iLoginView.showToast("登录失败，请检查账号和密码");
                }
            }
        }, 5000);
    }
}
