package com.ute.p205.cardmanager.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Link")
public class Link {
    @Id
    private Long id;
    private Long customerID;
    private String accountID;
    private String cardID;

}
