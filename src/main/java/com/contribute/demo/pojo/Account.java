package com.contribute.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * @ClassName : Account
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/12/20
 **/

@Entity
@Table(name="tb_account")
public class Account {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private String level;

    private String exp;

    private String nickname;

    private String identity;

    private String adv_url;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="userId",referencedColumnName="id")
    private Usermessage usermessage;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", level='" + level + '\'' +
                ", exp='" + exp + '\'' +
                ", nickname='" + nickname + '\'' +
                ", identity='" + identity + '\'' +
                ", adv_url='" + adv_url + '\'' +
                ", usermessage=" + usermessage +
                '}';
    }

    public String getAdv_url() {
        return adv_url;
    }

    public void setAdv_url(String adv_url) {
        this.adv_url = adv_url;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Usermessage getUsermessage() {
        return usermessage;
    }

    public void setUsermessage(Usermessage usermessage) {
        this.usermessage = usermessage;
    }
}
