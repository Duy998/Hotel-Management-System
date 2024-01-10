package com.nokia.hotel.entity;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;

public class RoomReservationEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "booked_at", nullable = false)
  private Date bookedAt;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private UserEntity user;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "payment_id", referencedColumnName = "id")
  private PaymentEntity payment;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "room_id", referencedColumnName = "id")
  private RoomEntity room;

  @FutureOrPresent
  @Column(name = "from_date", nullable = false)
  private Date fromDate;

  @Future
  @Column(name = "to_date", nullable = false)
  private Date toDate;

  public RoomReservationEntity(Date fromDate, Date toDate, Date bookedAt, RoomEntity room, UserEntity user) {
    this.fromDate = fromDate;
    this.toDate = toDate;
    this.bookedAt = bookedAt;
    this.room = room;
    this.user = user;
  }

  public RoomReservationEntity(Date fromDate, Date toDate, Date bookedAt, RoomEntity room, UserEntity user, PaymentEntity payment) {
    this.fromDate = fromDate;
    this.toDate = toDate;
    this.bookedAt = bookedAt;
    this.room = room;
    this.user = user;
    this.payment = payment;
  }
}
