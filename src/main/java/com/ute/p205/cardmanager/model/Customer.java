package com.ute.p205.cardmanager.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Customer")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Column(name = "UserName", unique = true, nullable = false)
    @NonNull private String username;
    @Column(name = "Password", nullable = false)
    @NonNull private String password;

    @ManyToMany
    @JoinTable(
            name = "Customer_Role",
            joinColumns = @JoinColumn(name = "Customer_ID"),
            inverseJoinColumns = @JoinColumn(name = "Role_ID")
    )
    private Set<Role> sysRoles = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "Status_id", referencedColumnName = "id")
    private CustomerStatus customerStatus;

  /*  @OneToMany(mappedBy = "Customer", cascade = CascadeType.ALL)
    //@PrimaryKeyJoinColumn fetch = FetchType.LAZY,
    private Set<Account> listBankAccounts = new HashSet<>();
    public void addBankAccount(Account bankAccount){
        listBankAccounts.add(bankAccount);
    }*/
}
/*
CREATE TABLE Customer(
        ID int not null primary key,
        UserName nvarchar(25) not null,
        Password nvarchar(25) not null,
        Status int not null,
        foreign key (Status) references SysStatus(ID) on update cascade on delete cascade
        );
 */