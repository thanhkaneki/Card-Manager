package com.ute.p205.cardmanager.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "LimitCreditCard")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
public class LimitCreditCard {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;
    @Column(name = "LimitMoney")
    @NonNull private String limitMoney;

    @ManyToOne
    @JoinColumn(name = "typeOfMoney_id", nullable = false)
    private TypeOfMoney typeOfMoney;

    @OneToMany(mappedBy = "limitCreditCard", cascade = CascadeType.ALL)
    private Set<Card> cards;
}



