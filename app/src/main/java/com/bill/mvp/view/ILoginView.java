package com.bill.mvp.view;

public interface ILoginView {
    void onClearText();

    void showToast(String tip);

    void hideProgressBar();

    void showProgressBar();
}
