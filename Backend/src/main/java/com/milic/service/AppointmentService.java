package com.milic.service;

import com.milic.api.model.AppointmentDto;
import com.milic.db.model.AppointmentStatus;
import com.milic.db.model.Appointment;
import com.milic.db.model.Pet;
import com.milic.db.model.User;
import com.milic.db.repositories.AppointmentRepo;
import java.time.ZoneId;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

  private final PetService petService;
  private final UserService userService;
  private final AppointmentRepo appointmentRepo;

  @Autowired
  public AppointmentService(PetService petService, UserService userService,
                            AppointmentRepo appointmentRepo) {
    this.petService = petService;
    this.userService = userService;
    this.appointmentRepo = appointmentRepo;
  }

  public Appointment create(AppointmentDto dto) {
    Appointment appointment = new Appointment();
    Pet pet = petService.getById(dto.getPetId());
    User vet = userService.getById(dto.getVetId());
    User owner = userService.getById(dto.getPetOwnerId());
    appointment.setPet(pet);
    appointment.setPetOwner(owner);
    appointment.setVet(vet);
    appointment.setAppointmentStatus(dto.getStatus());
    appointment.setTime(dto.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
    return appointmentRepo.save(appointment);
  }

  public List<Appointment> getByStatusAndUserId(AppointmentStatus status, Long userId) {
    return appointmentRepo.findByAppointmentStatusAndVetId(status, userId);
  }


}
