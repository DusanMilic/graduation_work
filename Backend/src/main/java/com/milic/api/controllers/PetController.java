package com.milic.api.controllers;

import com.milic.api.model.PetDto;
import com.milic.db.model.Pet;
import com.milic.service.PetService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/v1/pets")
public class PetController {

  private final PetService petService;

  @Autowired
  public PetController(PetService petService) {
    this.petService = petService;
  }

  @PostMapping
  public Pet create(PetDto petDto) {
    Pet pet;
    try {
      pet = petService.create(petDto);
    } catch (RuntimeException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }

    return pet;
  }

  @RequestMapping("/{id}")
  public Pet getById(@PathVariable("id") long id) {
    Pet pet = petService.getById(id);
    if (pet == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No pet with input ID");
    }
    return pet;
  }

  @RequestMapping("/owner/{id}")
  public List<Pet> getByOwnerId(@PathVariable("id") long ownerId) {
    return petService.findByOwner(ownerId);
  }

}
