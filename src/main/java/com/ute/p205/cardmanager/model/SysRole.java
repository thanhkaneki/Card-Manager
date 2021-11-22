package com.ute.p205.cardmanager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter @Setter
public class SysRole {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "Role")
    private String role;

    @ManyToMany(mappedBy = "sysRoles")
    private Set<SysAccount> users;

    public SysRole(){};
    public SysRole(String role) {
        this.role = role;
    }
}
/*CREATE TABLE SysRoles(
	ID int NOT NULL PRIMARY KEY,
	Role VARCHAR(12) NOT NULL
);
);*/
