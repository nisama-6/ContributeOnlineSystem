package com.contribute.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "tb_comment")
public class Comment {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "conId" ,referencedColumnName = "id")
    private Contribution contribution;//稿件的ID

    @OneToOne
    @JoinColumn(name = "accountId" ,referencedColumnName = "id")
    private Account account;

    private boolean isPass;//是否通过

    private String suggestion;//专家的建议内容
    private String suggestdate;//发表建议的日期

    public Comment() {
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", contribution=" + contribution +
                ", account=" + account +
                ", isPass=" + isPass +
                ", suggestion='" + suggestion + '\'' +
                ", suggestdate='" + suggestdate + '\'' +
                '}';

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contribution getContribution() {
        return contribution;
    }

    public void setContribution(Contribution contribution) {
        this.contribution = contribution;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getSuggestdate() {
        return suggestdate;
    }

    public void setSuggestdate(String suggestdate) {
        this.suggestdate = suggestdate;
    }

    public Comment(Contribution contribution, Account account, boolean isPass, String suggestion, String suggestdate) {
        this.contribution = contribution;
        this.account = account;
        this.isPass = isPass;
        this.suggestion = suggestion;
        this.suggestdate = suggestdate;
    }
}
