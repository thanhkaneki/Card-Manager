package com.ute.p205.cardmanager.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Account")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
public class Account {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "Number", unique = true, nullable = false)
    @NonNull private String number;

    @Column(name = "OpenDate" , nullable = false)
    private Date openDate;

    @Column(name = "Balance")
    private String balance;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private AccountType accountType;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private AccountStatus accountStatus;
//
//    @ManyToOne
////    @JoinColumn(name = "sysAccount_id")
////    private SysAccount sysAccount;
}
