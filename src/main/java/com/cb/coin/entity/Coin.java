package com.cb.coin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@ToString
public class Coin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;
    @Column(nullable = false, unique = true)
    private String token;
    @Column(nullable = false)
    private String chineseName;

    public Coin() {
    }

    public Coin(String token, String chineseName) {
        this.token = token;
        this.chineseName = chineseName;
    }
}
