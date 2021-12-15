package com.ute.p205.cardmanager.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "BankStatus")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class BankStatus {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "status", columnDefinition = "nvarchar(25)")
    @NonNull private String bankStatus;
}
