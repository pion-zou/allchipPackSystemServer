package com.allchip.pack.pojo;

import java.sql.Timestamp;
import java.util.List;

public class Contract {
    private int id;
    private String number;
    private String creator;
    private String remark;
    private String state;
    private Timestamp create_time;
    private Timestamp update_time;
    private String publish_time;
    private String editor;
    private List<Good> goodList;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public List<Good> getGoodList() {
        return goodList;
    }

    public void setGoodList(List<Good> goodList) {
        this.goodList = goodList;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", creator='" + creator + '\'' +
                ", remark='" + remark + '\'' +
                ", state='" + state + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", publish_time='" + publish_time + '\'' +
                ", editor='" + editor + '\'' +
                ", goodList=" + goodList +
                '}';
    }
}
