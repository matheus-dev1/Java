package br.com.matheus.spring.learning.matheuslearningjava18spring3.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

// Entidade, no banco de dados
@Entity
// Table que representa essa entidade
@Table(name = "person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    // Id, esse cara vai ser o identifcador unico da table
    @Id
    // Vai gerar e incrementar na tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Definindo o nome da coluna, neste caso e interresante colocar por que ele tem dois nomes First e name
    @Column(name = "first_name", nullable = false, length = 80)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 80)
    private String lastName;
    @Column(nullable = false, length = 100)
    private String address;
    @Column(nullable = false, length = 6)
    private String gender;

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /*
        O método equals() é usado para comparar a igualdade de dois objetos. Por padrão, a implementação do equals()
        na classe Object (de onde todas as classes herdam) compara as referências dos objetos, ou seja, verifica se
        dois objetos são exatamente o mesmo na memória.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && 
        Objects.equals(firstName, person.firstName) && 
        Objects.equals(lastName, person.lastName) && 
        Objects.equals(address, person.address) && 
        Objects.equals(gender, person.gender);
    }

    /*
        O método hashCode() retorna um valor inteiro que é usado pelas coleções baseadas em hash, como
        HashMap e HashSet, para armazenar objetos de forma eficiente. Ele deve ser implementado de
        forma consistente com o método equals().
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, gender);
    }
}
