package com.contribute.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

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
//    @JsonIgnore
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String username;

    @JsonIgnore
    private String password;

    private String identity;


    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy="account")
    private Usermessage usermessage;

//    @JsonIgnore
//    @OneToMany(orphanRemoval = true,mappedBy="author",fetch = FetchType.LAZY)
//    private List<Contribution> contributionList;


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


    public Usermessage getUsermessage() {
        return usermessage;
    }

    public void setUsermessage(Usermessage usermessage) {
        this.usermessage = usermessage;
    }

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", identity='" + identity + '\'' +
                ", usermessage=" + usermessage +
                '}';
    }

    public Account(String username, String password, String identity) {
        this.username = username;
        this.password = password;
        this.identity = identity;
    }

    //    public List<Contribution> getContributionList() {
//        return contributionList;
//    }
//
//    public void setContributionList(List<Contribution> contributionList) {
//        this.contributionList = contributionList;
//    }
}
