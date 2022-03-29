package com.example.exercisespringdataintrotwo.models;

import com.example.exercisespringdataintrotwo.models.constraints.annotions.Password;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    private int id;
    private String username;
    private String password;
    private String email;
    private LocalDate userRegistration;
    private LocalDate lastTimeUserLogged;
    private int age;
    private boolean isDeleted;
    private Town bornTown;
    private Town currentTown;
    private String firstName;
    private String lastName;
    private Set<User> friends;
    private Set<Album> albums;
    public String fullName = firstName + " " + lastName;

    public User(){
        this.friends = new LinkedHashSet<>();
        this.albums = new LinkedHashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(nullable = false)
    @Size(min = 4, max = 30)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false)
    @Password(minLength = 6, maxLength = 50, containsLowercase = true, containsUppercase = true,
            containsDigit = true, containsSpecialSymbol = true, message = "Invalid password")
    //@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d!@#$%^&*()_+<>?)]{6,50}$",
    // message = "Invalid password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(nullable = false)
    // @Email(regex = "[a-zA-Z0-9]+([\\.\\-\\_][a-zA-Z0-9]+)?@[a-zA-Z]{2,}\\.[a-zA-Z]{2,}",  message = "Invalid email)
    @Pattern(regexp = "[a-zA-Z0-9]+([\\.\\-\\_][a-zA-Z0-9]+)?@[a-zA-Z]{2,}\\.[a-zA-Z]{2,}", message = "Invalid email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // @CreationTimestamp
    @Column(name = "registered_on")
    public LocalDate getUserRegistration() {
        return userRegistration;
    }

    public void setUserRegistration(LocalDate userRegistration) {
        this.userRegistration = userRegistration;
    }

    @Column(name = "last_time_logged_in", columnDefinition = "TIMESTAMP")
    public LocalDate getLastTimeUserLogged() {
        return lastTimeUserLogged;
    }

    public void setLastTimeUserLogged(LocalDate lastTimeUserLogged) {
        this.lastTimeUserLogged = lastTimeUserLogged;
    }

    @Column
    @Min(1)
    @Max(120)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "is_deleted")
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @ManyToOne
    public Town getBornTown() {
        return bornTown;
    }

    public void setBornTown(Town bornTown) {
        this.bornTown = bornTown;
    }

    @ManyToOne
    public Town getCurrentTown() {
        return currentTown;
    }

    public void setCurrentTown(Town currentTown) {
        this.currentTown = currentTown;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToMany
    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    @OneToMany
    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    @Transient
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
