package com.example.mastersofpuppets.models;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Masters {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nameOfMaster;
    private String descriptionOfMaster;
    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "Masters")
    private List<Puppets> showPuppets;

    public Masters() {
    }

    public Masters(String nameOfMaster, String descriptionOfMaster, List<Puppets> showPuppets) {
        this.nameOfMaster = nameOfMaster;
        this.descriptionOfMaster = descriptionOfMaster;
        this.showPuppets = showPuppets;
    }

    public Masters(Object nameOfMasters) {
    }

    public String getNameOfMaster() {
        return nameOfMaster;
    }

    public void setNameOfMaster(String nameOfMaster) {
        this.nameOfMaster = nameOfMaster;
    }

    public String getDescriptionOfMaster() {
        return descriptionOfMaster;
    }

    public void setDescriptionOfMaster(String descriptionOfMaster) {
        this.descriptionOfMaster = descriptionOfMaster;
    }

    public List<Puppets> getShowPuppets() {
        return showPuppets;
    }

    public void setShowPuppets(List<Puppets> showPuppets) {
        this.showPuppets = showPuppets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Masters masters = (Masters) o;
        return id == masters.id && Objects.equals(nameOfMaster, masters.nameOfMaster) && Objects.equals(descriptionOfMaster, masters.descriptionOfMaster) && Objects.equals(showPuppets, masters.showPuppets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameOfMaster, descriptionOfMaster, showPuppets);
    }

    @Override
    public String toString() {
        return "Masters{" +
                "id=" + id +
                ", nameOfMaster='" + nameOfMaster + '\'' +
                ", descriptionOfMaster='" + descriptionOfMaster + '\'' +
                ", showPuppets=" + showPuppets +
                '}';
    }
}


