package com.example.myapp;

class EmailItem {
    private String title;
    private String subTitle;
    private String content;
    private String date;
    private String avatar;
    private boolean checkBox;

    public EmailItem(String title, String subTitle, String content, String date, String avatar, boolean checkBox) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.date = date;
        this.avatar = avatar;
        this.checkBox = checkBox;
    }

    String getTitle() {
        return title;
    }

    String getSubTitle() {
        return subTitle;
    }

    String getContent() {
        return content;
    }

    String getDate() {
        return date;
    }

    String getAvatar() {
        return avatar;
    }

    boolean getChechBox(){ return checkBox;}

    public void setCheckBox(boolean checkBox) {
        this.checkBox = checkBox;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Subtitle: " + ", Content: " + content + ", Date: " + date + ", Avarat: " + avatar + ".";
    }
}