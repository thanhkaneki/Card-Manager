package com.ute.p205.cardmanager.model;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Transaction")
@NoArgsConstructor
@Getter @Setter
public class Transaction {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;
    @Column(name = "customerID")
    private Long customerID;
    @Column(name = "accountID")
    private String accountID;
    @Column(name = "cardID")
    private String cardID;
    @Column(name = "time")
    private Date time;
    @Column(name = "money")
    private String money;
    @Column(name = "message")
    private String message;
}


