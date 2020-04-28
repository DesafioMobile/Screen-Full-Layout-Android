package com.example.screenshotfulllayout;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class PdfHolder extends RecyclerView.ViewHolder  {
    public TextView title;

    public PdfHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.main_line_title);
    }
}
