package com.demo.beans;

import java.time.LocalDate;

public class ToDo {
    private int id;
    private String title;
    private String username;
    private String detail;
    private LocalDate targetDate;
    private boolean statusDo;

    public ToDo() {

    }

    public ToDo(int id, String title, String username, String detail, LocalDate targetDate, boolean statusDo) {
        this.id = id;
        this.title = title;
        this.username = username;
        this.detail = detail;
        this.targetDate = targetDate;
        this.statusDo = statusDo;
    }

    public ToDo(String title, String username, String detail, LocalDate targetDate, boolean statusDo) {
        this.title = title;
        this.username = username;
        this.detail = detail;
        this.targetDate = targetDate;
        this.statusDo = statusDo;
    }

    public void getCheckStatus(){
        if(!statusDo){
            System.out.println("Pending");
        }else{
            System.out.println("Complete");

        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isStatusDo() {
        return statusDo;
    }

    public void setStatusDo(boolean statusDo) {
        this.statusDo = statusDo;
    }
}
