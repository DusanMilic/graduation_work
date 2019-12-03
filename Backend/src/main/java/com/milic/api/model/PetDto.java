package com.milic.api.model;

import com.milic.db.model.Species;

public class PetDto {

  private Long id;

  private Long ownerId;
  private String name;
  private String feedingHabits;
  private String breed;
  private int age;
  private int weight;
  private Species species;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(Long ownerId) {
    this.ownerId = ownerId;
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
}
