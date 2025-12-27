package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Fine {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long fineId;
  private Double amount;
  @OneToOne
  private Borrow borrow;

  public long getFineId() {
    return fineId;
  }
  public void setFineId(long fineId) {
    this.fineId = fineId;
  }
  public Double getAmount() {
    return amount;
  }
  public void setAmount(Double amount) {
    this.amount = amount;
  }
  public Borrow getBorrow() {
    return borrow;
  }
  public void setBorrow(Borrow borrow) {
    this.borrow = borrow;
  }
}











