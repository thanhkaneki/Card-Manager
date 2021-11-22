package com.ute.p205.cardmanager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "SysStatus")
@Getter @Setter
public class SysStatus {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name = "Status")
    private String status;

    @OneToOne(mappedBy = "sysStatus")
    private SysAccount sysAccount;
}
/*
CREATE TABLE SysStatus(
	ID int not null primary key,
    Status nvarchar(25) not null
);
*/
