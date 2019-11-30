package com.milic.api.controllers;

import com.milic.api.model.AppointmentDto;
import com.milic.db.model.Appointment;
import com.milic.db.model.AppointmentStatus;
import com.milic.service.AppointmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/appointments")
public class AppointmentController {

  private final AppointmentService appointmentService;

  @Autowired
  public AppointmentController(AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  @PostMapping(consumes = "application/json", produces = "application/json")
  Appointment createAppointment(@RequestBody AppointmentDto dto) {
    return appointmentService.create(dto);
  }

  @RequestMapping("/{vetId}/{appointmentStatus}")
  List<Appointment> getByTypeAndVetId(@PathVariable("vetId") long vetId,
                                      @PathVariable("appointmentStatus") AppointmentStatus status) {
    return appointmentService.getByStatusAndUserId(status, vetId);
  }
}
