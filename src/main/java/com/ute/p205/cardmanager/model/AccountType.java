package com.ute.p205.cardmanager.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "AccountType")
@Getter @Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "Name", nullable = false, unique = true)
    @NonNull
    private String name;

    @OneToMany(mappedBy = "accountType", cascade = CascadeType.ALL)
    private Set<Account> account;
}
/*CREATE TABLE AccountType(
    ID int primary key,
    Name Nvarchar(50) not null unique
)*/
