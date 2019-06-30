package com.bill.mvp.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bill.mvp.R;
import com.bill.mvp.presenter.ILoginPresenter;
import com.bill.mvp.presenter.LoginPresenter;

public class LoginActivity extends Activity implements ILoginView, View.OnClickListener {
    private EditText userNameEt, passwordEt;
    private Button loginBtn, clearBtn;
    private ProgressBar progressBar;

    private ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        bindListener();
        initData();
    }

    private void initData() {
        loginPresenter = new LoginPresenter(this);
    }


    private void initView() {
        userNameEt = findViewById(R.id.et_login_username);
        passwordEt = findViewById(R.id.et_login_password);
        loginBtn = findViewById(R.id.btn_login_login);
        clearBtn = findViewById(R.id.btn_login_clear);
        progressBar = findViewById(R.id.progress_login);
    }

    private void bindListener() {
        loginBtn.setOnClickListener(this);
        clearBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login_clear:
                loginPresenter.clear();
                break;
            case R.id.btn_login_login:
                loginPresenter.doLogin(userNameEt.getText().toString(), passwordEt.getText().toString());
                break;
            default:
                break;
        }
    }


    @Override
    public void onClearText() {
        userNameEt.setText("");
        passwordEt.setText("");
    }

    @Override
    public void showToast(String tip) {
        Toast.makeText(this, tip, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
        loginBtn.setEnabled(true);
        clearBtn.setEnabled(true);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
        loginBtn.setEnabled(false);
        clearBtn.setEnabled(false);
    }
}
