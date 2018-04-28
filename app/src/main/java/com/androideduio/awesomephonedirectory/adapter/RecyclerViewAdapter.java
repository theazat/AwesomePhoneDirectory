package com.androideduio.awesomephonedirectory.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androideduio.awesomephonedirectory.R;
import com.androideduio.awesomephonedirectory.activity.UserActivity;
import com.androideduio.awesomephonedirectory.model.User;
import com.androideduio.awesomephonedirectory.viewholder.RecyclerViewHolder;

import java.util.ArrayList;

/**
 * Created by Lenovo-PC on 25.08.2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {


    private ArrayList<User> userList = null;
    private Context context;


    public RecyclerViewAdapter(Context context, ArrayList<User> recyclerViewSubjects) {
        this.context = context;
        this.userList = recyclerViewSubjects;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_xml, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        final User userSubject = getItem(position);

        String mail = null, adres = null;
        if (userSubject.getMail().trim().length() < 1)
            mail = "---";
        else
            mail = userSubject.getMail();

        if (userSubject.getAdres().trim().length() < 1)
            adres = "---";
        else
            adres = userSubject.getAdres();

        holder.txtAdSoyad.setText(userSubject.getAd() + " " + userSubject.getSoyad());
        holder.txtTelefon.setText(userSubject.getTelefon());
        holder.txtMail.setText(userSubject.getMail());
        holder.txtAdres.setText(userSubject.getAdres());

        //Alternatif olarak RecyclerViewHolder.classı'nın içinde de yapabiliriz
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, UserActivity.class);
                intent.putExtra("user", userSubject);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (userList == null) ? 0 : userList.size();
    }

    private User getItem(int position) {

        return userList.get(position);
    }

}
