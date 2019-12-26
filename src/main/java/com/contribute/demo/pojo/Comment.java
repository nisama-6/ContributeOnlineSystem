package com.contribute.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "tb_comment")
@JsonIgnoreProperties(value = {"usermessage"})
public class Comment {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;


    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "expertId" ,referencedColumnName = "id")
    private Account expert;

    private boolean pass;//是否通过

    private String suggestion;//专家的建议内容
    private String suggestdate;//发表建议的日期


    @JoinColumn(name = "contributionId" ,referencedColumnName = "id")
    @OneToOne
    private Contribution contribution;
    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getExpert() {
        return expert;
    }

    public void setExpert(Account expert) {
        this.expert = expert;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
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

    public Comment(Account expert, boolean pass, String suggestion, String suggestdate) {
        this.expert = expert;
        this.pass = pass;
        this.suggestion = suggestion;
        this.suggestdate = suggestdate;
    }
}
