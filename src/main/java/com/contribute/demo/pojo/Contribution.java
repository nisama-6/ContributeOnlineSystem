package com.contribute.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "tb_contribution")
public class Contribution {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String url;
    private double wordnumber;
    private String kind;
    private String uploaddate;
    @OneToOne
    @JoinColumn(name = "accountId" ,referencedColumnName = "id")
    private Account account;//账户

    public Contribution() {
    }

    public Contribution(String name, String url, double wordnumber, String kind, String uploaddate, Account account) {
        this.name = name;
        this.url = url;
        this.wordnumber = wordnumber;
        this.kind = kind;
        this.uploaddate = uploaddate;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getWordnumber() {
        return wordnumber;
    }

    public void setWordnumber(double wordnumber) {
        this.wordnumber = wordnumber;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getUploaddate() {
        return uploaddate;
    }

    public void setUploaddate(String uploaddate) {
        this.uploaddate = uploaddate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Contribution{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", wordnumber=" + wordnumber +
                ", kind='" + kind + '\'' +
                ", uploaddate='" + uploaddate + '\'' +
                ", account=" + account +
                '}';
    }
}
