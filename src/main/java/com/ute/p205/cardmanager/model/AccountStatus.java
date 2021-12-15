package com.ute.p205.cardmanager.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Account_Status")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
public class AccountStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "Name", nullable = false, unique = true)
    @NonNull
    private String name;

    @OneToMany(mappedBy = "accountStatus", cascade = CascadeType.ALL)
    private Set<Account> accounts;
}
