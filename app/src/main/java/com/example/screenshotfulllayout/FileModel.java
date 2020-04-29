package com.example.screenshotfulllayout;

import java.util.Date;

public class FileModel {

    private final String fileName;
    private final String filePath;
    private final Date fileDate;
    private final String fileSize;



    public FileModel(String fileName, String filePath, Date fileDate, String fileSize) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileDate = fileDate;
        this.fileSize = fileSize;
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
    public String getFileSize() {
        return fileSize;
    }
}