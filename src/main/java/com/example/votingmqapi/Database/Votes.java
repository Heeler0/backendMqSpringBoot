package com.example.votingmqapi.Database;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
@Getter
@Setter
public class Votes{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String animal;


    public Votes(){}

    public Votes(String animal) {
        this.animal = animal;
    }

}
