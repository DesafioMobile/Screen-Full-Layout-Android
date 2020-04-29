package com.example.screenshotfulllayout;


import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;


public class PdfFragment extends Fragment {

    RecyclerView mRecyclerView;

    private PdfAdapter mAdapter;

    public PdfFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pdf_list, container, false);

        mRecyclerView = view.findViewById(R.id.recycler_view_layout_recycler);

        ArrayList<FileModel> pdfList = getFileList();
        setupRecycler(pdfList);

        return view;
    }

    private void setupRecycler(ArrayList pdfList) {

        // Configurando o gerenciador de layout para ser uma lista.
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        // Adiciona o adapter que irá anexar os objetos à lista.
        // Está sendo criado com lista vazia, pois será preenchida posteriormente.
        mAdapter = new PdfAdapter(pdfList, getContext());
        mRecyclerView.setAdapter(mAdapter);

        // Configurando um dividr entre linhas, para uma melhor visualização.
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
    }

    private ArrayList<FileModel> getFileList() {
        String path = Environment.getExternalStorageDirectory().toString()+"/Signature";


        File directory = new File(path);
        File[] files = directory.listFiles();

        ArrayList<FileModel> arrayFiles = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            arrayFiles.add(new FileModel(files[i].getName(),
                    files[i].getAbsolutePath(),
                    new Date(files[i].lastModified()),
                    getFileSize(files[i])));
        }

        return arrayFiles;
    }
    private static final DecimalFormat format = new DecimalFormat("#.##");
    private static final long MiB = 1024 * 1024;
    private static final long KiB = 1024;

    public String getFileSize(File file) {

        if (!file.isFile()) {
            throw new IllegalArgumentException("Expected a file");
        }
        final double length = file.length();

        if (length > MiB) {
            return format.format(length / MiB) + " MiB";
        }
        if (length > KiB) {
            return format.format(length / KiB) + " KiB";
        }
        return format.format(length) + " B";
    }
}