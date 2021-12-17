package com.ute.p205.cardmanager.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CardType")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
public class CardType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name", nullable = false, unique = true)
    @NonNull
    private String name;

    @OneToMany(mappedBy = "cardType", cascade = CascadeType.ALL)
    private Set<Card> cards;
}
