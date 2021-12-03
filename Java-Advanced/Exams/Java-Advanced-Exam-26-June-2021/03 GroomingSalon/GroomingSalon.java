package GroomingSalon_3_26June2021;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name){
        for (Pet pet: data){
            if(pet.getName().equals(name)){
                data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner){
        for (Pet pet: data){
            if(pet.getName().equals(name) && pet.getOwner().equals(owner)){
                return pet;
            }
        }
        return null;
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder statistics = new StringBuilder();
        statistics.append("The grooming salon has the following clients:").append(System.lineSeparator());
        for (Pet pet: data){
            statistics.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
        }
        return statistics.toString();
    }
}