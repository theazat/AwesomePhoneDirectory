package com.androideduio.awesomephonedirectory.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.androideduio.awesomephonedirectory.R;

public class LoginActivity extends AppCompatActivity implements TextWatcher,
        CompoundButton.OnCheckedChangeListener {

    private static final String PREF_NAME = "prefs";
    private static final String KEY_REMEMBER = "remember";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASS = "password";
    Button btnLogin;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private EditText etUsername;
    private EditText etPassword;
    private CheckBox rem_userPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

        if (sharedPreferences.getBoolean(KEY_REMEMBER, false))
            rem_userPass.setChecked(true);
        else
            rem_userPass.setChecked(false);

        etUsername.setText(sharedPreferences.getString(KEY_USERNAME, ""));
        etPassword.setText(sharedPreferences.getString(KEY_PASS, ""));

        etUsername.addTextChangedListener(this);
        etPassword.addTextChangedListener(this);
        rem_userPass.setOnCheckedChangeListener(this);


    }

    private void initView() {

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        etUsername = findViewById(R.id.activity_login_editText_userName);
        etPassword = findViewById(R.id.activity_login_editText_password);
        rem_userPass = findViewById(R.id.activity_login_checkBox_beniHatırla);
        btnLogin = findViewById(R.id.activity_login_button_Login);
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        //managePrefs();
    }


    @Override
    public void afterTextChanged(Editable editable) {
        managePrefs();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        managePrefs();
    }


    private void managePrefs() {


        String s1 = etUsername.getText().toString();
        String s2 = etPassword.getText().toString();

        if (s1.equals("") || s2.equals("")) {
            btnLogin.setEnabled(false);
        } else {
            btnLogin.setEnabled(true);
        }


        if (rem_userPass.isChecked()) {
            editor.putString(KEY_USERNAME, etUsername.getText().toString().trim());
            editor.putString(KEY_PASS, etPassword.getText().toString().trim());
            editor.putBoolean(KEY_REMEMBER, true);
            editor.apply();
        } else {
            editor.putBoolean(KEY_REMEMBER, false);
            editor.remove(KEY_PASS); //editor.putString(KEY_PASS, "");
            editor.remove(KEY_USERNAME); //editor.putString(KEY_USERNAME, "");
            editor.apply();
        }


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginActivity.this, ViewPagerActivity.class);
                startActivity(intent);

            }
        });
    }
}
