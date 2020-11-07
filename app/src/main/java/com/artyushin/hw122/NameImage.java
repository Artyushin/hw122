package com.artyushin.hw122;

public class NameImage {
    private static String fileName;

    public static void setFileName(String fileName) {
        NameImage.fileName = fileName;
    }

    public static String getFileName() {
        return fileName;
    }

    public String toString(){
        return String.valueOf(fileName);
    }


}
