package com.milic.db.model;

import com.milic.api.model.PetDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pets")
public class Pet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "owner")
  private User owner;

  private String name;
  private String feedingHabits;
  private String alergies;
  private String breed;
  private int age;
  private int weight;

  @Enumerated(EnumType.STRING)
  private Species species;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFeedingHabits() {
    return feedingHabits;
  }

  public void setFeedingHabits(String feedingHabits) {
    this.feedingHabits = feedingHabits;
  }

  public String getAlergies() {
    return alergies;
  }

  public void setAlergies(String alergies) {
    this.alergies = alergies;
  }

  public String getBreed() {
    return breed;
  }

  public void setBreed(String breed) {
    this.breed = breed;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public Species getSpecies() {
    return species;
  }

  public void setSpecies(Species species) {
    this.species = species;
  }

  public static Pet fromDto(PetDto petDto) {
    Pet pet = new Pet();
    pet.setAge(petDto.getAge());
    pet.setAlergies(petDto.getAlergies());
    pet.setBreed(petDto.getBreed());
    pet.setFeedingHabits(petDto.getFeedingHabits());
    pet.setName(petDto.getName());
    pet.setSpecies(petDto.getSpecies());
    pet.setWeight(petDto.getWeight());
    pet.setId(petDto.getId());
    return pet;
  }
}
