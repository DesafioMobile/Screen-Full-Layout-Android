package com.example.screenshotfulllayout;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class PdfHolder extends RecyclerView.ViewHolder  {
    public TextView txt_name;
    public TextView txt_data;
    public TextView txt_sizeFile;
    public LinearLayout holder_view;


    public PdfHolder(View itemView) {
        super(itemView);
        txt_name = (TextView) itemView.findViewById(R.id.txt_name);
        txt_data = (TextView) itemView.findViewById(R.id.txt_data);
        txt_sizeFile = (TextView) itemView.findViewById(R.id.txt_sizeFile);
        holder_view = (LinearLayout) itemView.findViewById(R.id.holder_view);
    }
}
