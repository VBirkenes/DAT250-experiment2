package no.hvl.dat250.jpa.basicexample;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data                                   
public class Address {                                              
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String street;
    private Integer number;

    @OneToOne
    private Person person;

    public Address() {

    }
}
