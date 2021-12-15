package com.ute.p205.cardmanager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CustomerInfo")
@NoArgsConstructor
@Getter
@Setter
public class CustomerInfo {
    @Id
    @Column(name = "Customer_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "ID")
    private Customer customer;

    @Column(name = "FirstName", nullable = false)
    private  String firstName;
    @Column(name = "LastName", nullable = false)
    private String lastName;
    @Column(name = "Address", nullable = false)
    private String address;
    @Column(name = "PhoneNumber", unique = true, nullable = false)
    private String phoneNumber;
}
/*CREATE TABLE SysAccountInfo(
	User_ID int not null primary key,
    FirstName nvarchar(25) not null,
    LastName nvarchar(25) not null,
    Address nvarchar(255) not null,
    PhoneNumber nvarchar(10) not null,
    foreign key (User_ID) references Users (ID) on update cascade on delete cascade
);*/