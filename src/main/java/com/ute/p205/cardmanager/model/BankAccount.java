package com.ute.p205.cardmanager.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BankAccount")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class BankAccount {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;
    @Column(name = "Number")
    @NonNull private String number;
    @Column(name = "OpenDate")
    private Date openDate;

    @ManyToOne
    @JoinColumn(name = "Account_id")
    private SysAccount sysAccount;
}
