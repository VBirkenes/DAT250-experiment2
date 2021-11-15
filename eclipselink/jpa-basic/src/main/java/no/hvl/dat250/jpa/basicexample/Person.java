package no.hvl.dat250.jpa.basicexample;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;

    @OneToOne
    @PrimaryKeyJoinColumn(name="creditcard_id")
    private CreditCard creditCard;

    @ManyToMany
    @PrimaryKeyJoinColumn(name="address")
    private Address address;
}
