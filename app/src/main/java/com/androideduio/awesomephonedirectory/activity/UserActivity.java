package com.androideduio.awesomephonedirectory.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.androideduio.awesomephonedirectory.R;
import com.androideduio.awesomephonedirectory.adapter.DataBaseAdapter;
import com.androideduio.awesomephonedirectory.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity implements View.OnClickListener {


    EditText etAd, etSoyad, etTelefon, etMail, etAdres;

    Spinner spCinsiyet;

    Button btnGuncelle, btnSil;

    private User user = null;

    private int updateCount = 0;
    private DataBaseAdapter db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Bundle bundle = getIntent().getExtras();
        user = bundle.getParcelable("user");

        initView();
        spinnerView();
        initEvent();
    }


    private void initView() {
        etAd = findViewById(R.id.activity_user_edittext_edtAd);
        etSoyad = findViewById(R.id.activity_user_edittext_edtSoyad);
        etTelefon = findViewById(R.id.activity_user_edittext_edtTelefon);
        etMail = findViewById(R.id.activity_user_edittext_edtMail);
        etAdres = findViewById(R.id.activity_user_edittext_edtAdres);
        spCinsiyet = findViewById(R.id.activity_user_spinner_spCinsiyet);
        btnGuncelle = findViewById(R.id.activity_user_button_btnGuncelle);
        btnSil = findViewById(R.id.activity_user_button_btnSil);

        db = new DataBaseAdapter(this);


        btnGuncelle.setOnClickListener(this);
        btnSil.setOnClickListener(this);
    }

    private void spinnerView() {

        List<String> cinsiyet = new ArrayList<>();

        cinsiyet.add("Kadın");
        cinsiyet.add("Erkek");

        ArrayAdapter cinsiyetAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cinsiyet);
        cinsiyetAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCinsiyet.setAdapter(cinsiyetAdapter);
    }

    private void initEvent() {

        etAd.setText(user.getAd());
        etSoyad.setText(user.getSoyad());
        etTelefon.setText(user.getTelefon());
        etMail.setText(user.getMail());
        etAdres.setText(user.getAdres());

        if (user.getCinsiyet().equals("Kadın"))
            spCinsiyet.setSelection(0);
        else
            spCinsiyet.setSelection(1);
    }

    private void usingData() {
        etAd.setEnabled(true);
        etSoyad.setEnabled(true);
        etTelefon.setEnabled(true);
        etMail.setEnabled(true);
        etAdres.setEnabled(true);
        spCinsiyet.setEnabled(true);
    }

    private User createUserObject() {

        return new User(user.getID(), etAd.getText().toString(), etSoyad.getText().toString(),
                etTelefon.getText().toString(),
                etMail.getText().toString(), etAdres.getText().toString(), spCinsiyet.getSelectedItem().toString());
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.activity_user_button_btnGuncelle:
                updateCount++;
                if (updateCount == 1)
                    usingData();
                if (updateCount == 2) {
                    db.updateUser(createUserObject());
                    updateCount = 0;
                    Toast.makeText(this, "Güncelleme Başarılı!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(this, ViewPagerActivity.class);
                    intent.putExtra("userScreen", true);
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.activity_user_button_btnSil:
                db.deleteUser(createUserObject());
                Toast.makeText(this, "Silme işlemi Başarılı!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, ViewPagerActivity.class);
                intent.putExtra("userScreen", true);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
    }
}
