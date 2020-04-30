package com.example.screenshotfulllayout;

import android.content.Context;
import android.content.Intent;
import android.content.ReceiverCallNotAllowedException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PdfAdapter extends RecyclerView.Adapter<PdfHolder> {

    private final List<FileModel> mFiles;
    private final Context ctx;


    public PdfAdapter(ArrayList files, Context ctx) {
        mFiles = files;
        this.ctx = ctx;
    }

    @Override
    public PdfHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PdfHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_line_view, parent, false));
    }

    @Override
    public void onBindViewHolder(PdfHolder holder, final int position) {
    holder.txt_name.setText(
                mFiles.get(position).getFileName());
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
    Date dateFormatter = mFiles.get(position).getFileDate();
    String dateText = dateFormat.format(dateFormatter);
    holder.txt_data.setText(dateText);
    holder.txt_sizeFile.setText(
                mFiles.get(position).getFileSize());


        holder.holder_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFile(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFiles != null ? mFiles.size() : 0;
    }

    public void updateList(FileModel file) {
        insertItem(file);
    }

    private void insertItem(FileModel file) {
        mFiles.add(file);
        notifyItemInserted(getItemCount());
    }

    private void openFile(int position){
        String filePath = mFiles.get(position).getFilePath();
        File file = new File(filePath);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(FileProvider.getUriForFile(ctx, "com.example.screenshotfulllayout.provider", file), "application/pdf");
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        ctx.startActivity(intent);
    }
}
