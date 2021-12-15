package com.ute.p205.cardmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "Card")
public class Card {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "Number")
    private long number;

}
