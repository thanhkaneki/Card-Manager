package com.ute.p205.cardmanager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "SysAccount")
@Getter @Setter
public class SysAccount {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "UserName")
    private String username;
    @Column(name = "Password")
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "User_ID"),
            inverseJoinColumns = @JoinColumn(name = "Role_ID")
    )
    private Set<SysRole> sysRoles;

    @OneToOne
    @JoinColumn(name = "status", referencedColumnName = "id")
    private SysStatus sysStatus;
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