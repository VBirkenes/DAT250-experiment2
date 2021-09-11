package no.hvl.dat250.jpa.basicexample;

import lombok.Data;
import org.eclipse.persistence.annotations.ReadOnly;

import javax.persistence.*;

@Entity
@Data
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    
    private Integer number;
    private Integer limit;
    private Integer balance;

    @OneToOne
    private Bank bank;

    @OneToOne
    private Pincode pinCode;

    public CreditCard() {

    }
}
