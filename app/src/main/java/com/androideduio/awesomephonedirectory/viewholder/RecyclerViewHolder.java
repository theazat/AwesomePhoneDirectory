package com.androideduio.awesomephonedirectory.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.androideduio.awesomephonedirectory.R;

/**
 * Created by Lenovo-PC on 25.08.2017.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {


    public TextView txtAdSoyad = null, txtTelefon = null, txtMail = null, txtAdres = null;

    public RecyclerViewHolder(View view) {

        super(view);

        txtAdSoyad = itemView.findViewById(R.id.row_xml_textView_adSoyad);
        txtTelefon = itemView.findViewById(R.id.row_xml_textView_telefon);
        txtMail = itemView.findViewById(R.id.row_xml_textView_mail);
        txtAdres = itemView.findViewById(R.id.row_xml_textView_adres);
    }
}
