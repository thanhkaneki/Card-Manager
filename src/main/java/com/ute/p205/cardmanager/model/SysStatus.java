package com.ute.p205.cardmanager.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "SysStatus")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class SysStatus {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name = "Status")
    @NonNull private String status;

    @OneToOne(mappedBy = "sysStatus")
    private SysAccount sysAccount;
}
/*
CREATE TABLE SysStatus(
	ID int not null primary key,
    Status nvarchar(25) not null
);
*/
