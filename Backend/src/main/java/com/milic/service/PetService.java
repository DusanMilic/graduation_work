package com.milic.service;

import com.milic.api.model.PetDto;
import com.milic.db.model.Pet;
import com.milic.db.model.User;
import com.milic.db.repositories.PetRepo;
import com.milic.db.repositories.UserRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

  private final PetRepo petRepo;
  private final UserRepo userRepo;

  @Autowired
  public PetService(PetRepo petRepo, UserRepo userRepo) {
    this.petRepo = petRepo;
    this.userRepo = userRepo;
  }

  public Pet create(PetDto petDto) {
    Optional<User> owner = userRepo.findById(petDto.getOwnerId());
    if (!owner.isPresent()) {
      throw new RuntimeException("No user with id " + petDto.getOwnerId());
    }

    Pet pet = Pet.fromDto(petDto);
    pet.setOwner(owner.get());
    return petRepo.save(pet);
  }

  public Pet getById (Long id) {
    return petRepo.findById(id).orElse(null);
  }

  public List<Pet> findByOwner(Long ownerId) {
    Optional<User> owner = userRepo.findById(ownerId);
    return owner.map(petRepo::findByOwner).orElse(null);
  }
}
