package com.example.exercisespringdataautomappingobjects.models.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "carts")
public class Cart {

    private Long id;
    private Set<Game> addedGames;

    public Cart(){
        this.addedGames = new LinkedHashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Game> getAddedGames() {
        return addedGames;
    }

    public void setAddedGames(Set<Game> addedGames) {
        this.addedGames = addedGames;
    }
}
