package com.ute.p205.cardmanager.model;

import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SysAccount")
@Data
public class SysAccount {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Column(name = "UserName")
    private String username;
    @Column(name = "Password")
    private String password;

    @ManyToMany
    @JoinTable(
            name = "SysAccount_SysRole",
            joinColumns = @JoinColumn(name = "Acc_ID"),
            inverseJoinColumns = @JoinColumn(name = "Role_ID")
    )
    private Set<SysRole> sysRoles;

    @OneToOne
    @JoinColumn(name = "Status_id", referencedColumnName = "id")
    private SysStatus sysStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sysAccount")
    @PrimaryKeyJoinColumn
    private Set<BankAccount> listBankAccounts = new HashSet<>();
}
/*
CREATE TABLE SysAccount(
        ID int not null primary key,
        UserName nvarchar(25) not null,
        Password nvarchar(25) not null,
        Status int not null,
        foreign key (Status) references SysStatus(ID) on update cascade on delete cascade
        );
 */