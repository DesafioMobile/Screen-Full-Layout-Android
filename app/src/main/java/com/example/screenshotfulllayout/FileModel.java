package com.example.screenshotfulllayout;

import java.util.Date;

public class FileModel {

    private final String fileName;
    private final String filePath;
    private final Date fileDate;

    public FileModel(String fileName, String filePath, Date fileDate) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileDate = fileDate;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public Date getFileDate(){
        return fileDate;
    }
}