package com.project.visaoonline.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_partner")
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private Long id;

    @Column(name = "decade")
    private LocalDate decade;

    @Column(name = "name")
    private String name;

    @Column(name = "region")
    private String region;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "tokenizer")
    private String tokenizer;

    @Column(name = "statesman")
    private int statesman;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDecade() {
        return decade;
    }

    public void setDecade(LocalDate decade) {
        this.decade = decade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTokenizer() {
        return tokenizer;
    }

    public void setTokenizer(String tokenizer) {
        this.tokenizer = tokenizer;
    }

    public int getStatesman() {
        return statesman;
    }

    public void setStatesman(int statesman) {
        this.statesman = statesman;
    }
}
