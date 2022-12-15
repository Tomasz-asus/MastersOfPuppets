package com.example.mastersofpuppets.models;

import jakarta.persistence.*;


import java.util.List;
import java.util.Objects;

@Entity

public class Puppets {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nameOfPuppet;
    private String descriptionOfPuppet;
    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "Puppets")
    private List<Masters>showMasters;

    public Puppets() {
    }

    public Puppets(String nameOfPuppet, String descriptionOfPuppet, List<Masters> showMasters) {
        this.nameOfPuppet = nameOfPuppet;
        this.descriptionOfPuppet = descriptionOfPuppet;
        this.showMasters = showMasters;
    }

    public String getNameOfPuppet() {
        return nameOfPuppet;
    }

    public void setNameOfPuppet(String nameOfPuppet) {
        this.nameOfPuppet = nameOfPuppet;
    }

    public String getDescriptionOfPuppet() {
        return descriptionOfPuppet;
    }

    public void setDescriptionOfPuppet(String descriptionOfPuppet) {
        this.descriptionOfPuppet = descriptionOfPuppet;
    }

    public List<Masters> getShowMasters() {
        return showMasters;
    }

    public void setShowMasters(List<Masters> showMasters) {
        this.showMasters = showMasters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Puppets puppets = (Puppets) o;
        return id == puppets.id && Objects.equals(nameOfPuppet, puppets.nameOfPuppet) && Objects.equals(descriptionOfPuppet, puppets.descriptionOfPuppet) && Objects.equals(showMasters, puppets.showMasters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameOfPuppet, descriptionOfPuppet, showMasters);
    }

    @Override
    public String toString() {
        return "Puppets{" +
                "id=" + id +
                ", nameOfPuppet='" + nameOfPuppet + '\'' +
                ", descriptionOfPuppet='" + descriptionOfPuppet + '\'' +
                ", showMasters=" + showMasters +
                '}';
    }
}
