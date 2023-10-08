package com.barokah.bean.validator;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Person {
    @Size(max = 20, message = "max first name length is 20 characters")
    @NotBlank(message = "first name can not be blank")
    private String firstName;

    @Size(max = 20, message = "max last name length is 20 characters")
    @NotBlank(message = "last name can not be blank")
    private String lastName;

    @NotNull
    @Valid
    // by default field which is object is not validated. In order to make the field validated we have to use @Valid annotation
    private Address address;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Valid // validate object person when it is created
    public Person(
            @NotBlank(message = "first name can not blank") String firstName,
            @NotBlank(message = "last name can not blank") String lastName,
            @NotNull(message = "address can not null") @Valid Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void sayHello(@NotBlank(message = "name can not blank") String name) {
        System.out.println("Hello " + name + ", my name is " + firstName);
    }

    @NotBlank(message = "full name can not blank")
    public String fullName(){
        return firstName + " " +lastName;
    }
}
