package com.ute.p205.cardmanager.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TypeOfMoney")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
public class TypeOfMoney {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;
    @Column(name = "Name", nullable = false, unique = true)
    @NonNull private String name;
    @Column(name = "FullName", nullable = false, unique = true)
    @NonNull private String fullName;

    @OneToMany(mappedBy = "typeOfMoney", cascade = CascadeType.ALL)
    private Set<LimitCreditCard> limitCreditCards;
}
