package com.ute.p205.cardmanager.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CustomerStatus")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
public class CustomerStatus {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name = "Status")
    @NonNull private String status;

    @OneToOne(mappedBy = "customerStatus")
    private Customer customer;
}
/*
CREATE TABLE SysStatus(
	ID int not null primary key,
    Status nvarchar(25) not null
);
*/
