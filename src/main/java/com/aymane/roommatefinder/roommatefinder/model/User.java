package com.aymane.roommatefinder.roommatefinder.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

@Id
private String id;
private String email;
private String password;
private String firstName;
private String lastName;

private Integer minBudget;
private Integer maxBudget;
private String lifestyle;
private Boolean smokingOk;
private Boolean petsOk;

private String bio;
private Integer age;
private String gender;

private boolean active = true;

}
