package com.ute.p205.cardmanager.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "Card")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Card {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;  

    @Column(name = "Number")  
    @NonNull private String number;

    @Column(name = "ValiDate")  
    @NonNull private String valiDate;
    @Column(name = "ExpiryDate")
    @NonNull private String expiryDate;

    @ManyToOne  
    @JoinColumn(name = "type_id")
    private CardType cardType;

    @ManyToOne  
    @JoinColumn(name = "LimitCredit_ID")
    private LimitCreditCard limitCreditCard;

    @ManyToOne  
    @JoinColumn(name = "status_id")
    private CardStatus cardStatus;
}
