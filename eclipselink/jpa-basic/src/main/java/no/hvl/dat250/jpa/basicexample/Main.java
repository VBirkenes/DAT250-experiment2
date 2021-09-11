package no.hvl.dat250.jpa.basicexample;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "creditcard";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = em.createQuery("select p from Person p");
        List<Person> personList = q.getResultList();
        for (Person person : personList) {
            System.out.println(personList);
        }
        System.out.println("Size: " + personList.size());

        // Create our objects
        Person person = new Person();
        person.setName("Max Mustermann");
        person.setId(1L);
        Address address = new Address();
        address.setStreet("Inndalsveien");
        address.setNumber(28);
        address.setId(1L);
        CreditCard creditCard = new CreditCard();
        creditCard.setNumber(12345);
        creditCard.setBalance(-5000);
        creditCard.setLimit(-10000);
        creditCard.setId(1L);
        Pincode pincode = new Pincode();
        pincode.setPincode("123");
        pincode.setCount(1);
        pincode.setId(1L);
        Bank bank = new Bank();
        bank.setName("Pengebank");
        bank.setId(1L);

        // Add all the dependencies
        //creditCard.setBank(bank);
        //person.addAdress(address);
        //person.addCreditCard(creditCard);
        //address.addPerson(person);
        //creditCard.setPincode(pincode);
        //creditCard.setPerson(person);
        //bank.addCreditCard(creditCard);


        em.getTransaction().begin();

        em.persist(person);
        em.persist(address);
        em.persist(creditCard);
        em.persist(bank);

        em.getTransaction().commit();
        em.close();

        /*Todo todo = new Todo();
        todo.setSummary("This is a test");
        todo.setDescription("This is a test");
        em.persist(todo);
        em.getTransaction().commit();

        em.close();*/
    }
}
