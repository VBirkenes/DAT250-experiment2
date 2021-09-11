package no.hvl.dat250.jpa.basicexample;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String pincode;
    private Integer count;
}
