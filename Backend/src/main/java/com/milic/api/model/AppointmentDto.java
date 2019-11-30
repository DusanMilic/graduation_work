package com.milic.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.milic.db.model.AppiontmentStatus;
import java.util.Date;

public class AppointmentDto {
  private long vetId;
  private long petOwnerId;
  private long petId;
  private AppiontmentStatus status = AppiontmentStatus.WAITING;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private Date date;

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public long getVetId() {
    return vetId;
  }

  public void setVetId(long vetId) {
    this.vetId = vetId;
  }

  public long getPetOwnerId() {
    return petOwnerId;
  }

  public void setPetOwnerId(long petOwnerId) {
    this.petOwnerId = petOwnerId;
  }

  public long getPetId() {
    return petId;
  }

  public void setPetId(long petId) {
    this.petId = petId;
  }

  public AppiontmentStatus getStatus() {
    return status;
  }

  public void setStatus(AppiontmentStatus status) {
    this.status = status;
  }
}
