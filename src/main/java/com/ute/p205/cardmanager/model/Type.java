package com.ute.p205.cardmanager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "type")
@Getter @Setter
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
}
