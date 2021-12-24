package com.ute.p205.cardmanager.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Roles")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
public class Role {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Column(name = "Role", unique = true, nullable = false)
    @NonNull private String role;

    @ManyToMany(mappedBy = "sysRoles")
    private Set<Customer> accounts = new HashSet<>();
}
/*CREATE TABLE SysRoles(
	ID int NOT NULL PRIMARY KEY,
	Role VARCHAR(12) NOT NULL
);
);*/


