package com.androideduio.awesomephonedirectory.fragment;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.androideduio.awesomephonedirectory.R;
import com.androideduio.awesomephonedirectory.adapter.DataBaseAdapter;
import com.androideduio.awesomephonedirectory.adapter.RecyclerViewAdapter;
import com.androideduio.awesomephonedirectory.model.User;

import java.util.ArrayList;


public class ContactListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {


    DataBaseAdapter db;
    private View fLayout;
    private RecyclerView recyclerViewList = null;
    private SwipeRefreshLayout swipeRefreshLayout = null;
    // private Toolbar refreshToolbar = null;
    private ArrayList<User> userArrayList = null;


    public ContactListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fLayout = inflater.inflate(R.layout.fragment_contact_list, container, false);

        initView();
        return fLayout;
    }

    private void initView() {

        recyclerViewList = fLayout.findViewById(R.id.fragment_contact_recyclerViewList);
        swipeRefreshLayout = fLayout.findViewById(R.id.fragment_contact_swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(this);

        initEvent();
    }

    private void initEvent() {

        db = new DataBaseAdapter(getContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewList.setLayoutManager(linearLayoutManager);
        recyclerViewList.setItemAnimator(new DefaultItemAnimator());

        checkData();

    }

    private void checkData() {
        try {
            userArrayList = db.getAllUser();
        } catch (Exception e) {
            Toast.makeText(getContext(), "Bir hata var checkData() metoduna bak " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), userArrayList);
        recyclerViewList.setAdapter(adapter);

    }

    @Override
    public void onRefresh() {

        new CountDownTimer(2000, 1000) {


            @Override
            public void onTick(long millisUntilFinished) {

                Toast.makeText(getContext(), "Kayıtlar Yükleniyor", Toast.LENGTH_SHORT).show();
                checkData();
            }

            @Override
            public void onFinish() {

                swipeRefreshLayout.setRefreshing(false);
            }
        }.start();

    }
}


