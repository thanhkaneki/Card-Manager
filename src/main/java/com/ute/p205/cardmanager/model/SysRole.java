package com.ute.p205.cardmanager.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "SysRoles")
@Data
public class SysRole {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Column(name = "Role")
    private String role;

    @ManyToMany(mappedBy = "sysRoles")
    private Set<SysAccount> accounts;

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
