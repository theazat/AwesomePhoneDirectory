package com.androideduio.awesomephonedirectory.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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


public class SecondFragment extends Fragment implements TextWatcher, View.OnClickListener, AdapterView.OnItemSelectedListener {

    private static View fLayout;
    EditText txtAd, txtSoyad, txtTelefon, txtMail, txtAdres;
    Spinner spCinsiyet;
    Button btnKaydet;
    DataBaseAdapter db;

    public SecondFragment() {
        // Required empty public constructor
    }


    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        fLayout = inflater.inflate(R.layout.fragment_second, container, false);

        initView();
        spinnerMethod();
        return fLayout;
    }

    private void initView() {

        txtAd = fLayout.findViewById(R.id.fragment_second_editText_edtAd);
        txtSoyad = fLayout.findViewById(R.id.fragment_second_editText_edtSoyad);
        txtTelefon = fLayout.findViewById(R.id.fragment_second_editText_edtTelefon);
        txtMail = fLayout.findViewById(R.id.fragment_second_editText_edtMail);
        txtAdres = fLayout.findViewById(R.id.fragment_second_editText_edtAdres);
        spCinsiyet = fLayout.findViewById(R.id.fragment_second_spinner_spCinsiyet);
        btnKaydet = fLayout.findViewById(R.id.fragment_second_button_btnKaydet);

        db = new DataBaseAdapter(getContext());

        txtAd.addTextChangedListener(this);
        txtSoyad.addTextChangedListener(this);
        txtTelefon.addTextChangedListener(this);
        txtMail.addTextChangedListener(this);
        txtAdres.addTextChangedListener(this);

        spCinsiyet.setOnItemSelectedListener(this);
        btnKaydet.setOnClickListener(this);
    }

    private void spinnerMethod() {

        List<String> cinsiyet = new ArrayList<>();

        cinsiyet.add("Kadın");
        cinsiyet.add("Erkek");

        ArrayAdapter cinsiyetAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, cinsiyet);
        cinsiyetAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCinsiyet.setAdapter(cinsiyetAdapter);
        spCinsiyet.setSelection(0);
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

        if (txtAd.getText().length() > 0 && txtSoyad.getText().length() > 0 && txtTelefon.getText().length() > 0) {
            btnKaydet.setEnabled(true);
        } else {
            btnKaydet.setEnabled(false);
        }
    }

    private User createUserObject(String ad, String soyad, String telefon, String mail, String adres, String cinsiyet) {


        User user = new User(ad, soyad, telefon, mail, adres, cinsiyet);

        return user;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.fragment_second_button_btnKaydet:
                boolean mailCheck = false;
                if (txtMail.getText().toString().length() > 0)
                    mailCheck = isValidEmail(txtMail.getText().toString());
                else
                    mailCheck = true;

                if (mailCheck) {
                    try {
                        db.addContact(createUserObject(txtAd.getText().toString(), txtSoyad.getText().toString(), txtTelefon.getText().toString(),
                                txtMail.getText().toString(), txtAdres.getText().toString(), spCinsiyet.getSelectedItem().toString()));
                        Toast.makeText(getContext(), "Kayıt Olma Başarılı!", Toast.LENGTH_SHORT).show();
                    } catch (Exception ex) {
                        Toast.makeText(getContext(), "Hata : " + ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(getContext(), "Mail address is not valid", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
