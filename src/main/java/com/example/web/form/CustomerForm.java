package com.example.web.form;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class CustomerForm {

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate birthday;

    public CustomerForm(String firstName,
                        String lastName,
                        String email,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
    }

    /**
     * フィールドがすべて空（null）のCustomerFormインスタンスを生成するメソッド
     */
    public static CustomerForm createEmptyForm() {
        return new CustomerForm(null, null, null, null);
    }

//    /**
//     * エンティティのCustomerに変換するメソッド
//     */
//    public Customer convertToEntity() {
//        return new Customer(firstName, lastName, email, birthday);
//    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
