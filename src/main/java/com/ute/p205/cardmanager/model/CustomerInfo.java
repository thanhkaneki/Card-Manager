package com.ute.p205.cardmanager.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CustomerInfo")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class CustomerInfo {
    @Id
    @Column(name = "Customer_ID")
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "Customer_ID")
    private Customer customer;

    @Column(name = "FirstName", nullable = false)
    @NonNull private  String firstName;
    @Column(name = "LastName", nullable = false)
    @NonNull private String lastName;
    @Column(name = "Address", nullable = false)
    @NonNull private String address;
    @Column(name = "PassPort_ID")
    @NonNull private String passPortOrID;
    @Column(name = "ValiDate")
    @NonNull private String valiDate;
    @Column(name = "ExpiryDate")
    @NonNull private String expiryDate;
    @Column(name = "PhoneNumber", unique = true, nullable = false)
    @NonNull private String phoneNumber;
    @Column(name = "Email")
    @NonNull private String email;

}
/*CREATE TABLE SysAccountInfo(
	User_ID int not null primary key,
    FirstName nvarchar(25) not null,
    LastName nvarchar(25) not null,
    Address nvarchar(255) not null,
    PhoneNumber nvarchar(10) not null,
    foreign key (User_ID) references Users (ID) on update cascade on delete cascade
);*/