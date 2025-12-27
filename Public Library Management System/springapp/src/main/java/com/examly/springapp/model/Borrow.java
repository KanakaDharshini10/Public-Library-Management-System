package com.examly.springapp.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Borrow {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long borrowId;
  @ManyToOne
  private Book book;
  @ManyToOne
  private Member employee;
  private Date borrowDate;
  private Date returnDate;

  public long getBorrowId() {
    return borrowId;
  }
  public void setBorrowId(long borrowId) {
    this.borrowId = borrowId;
  }
  public Book getBook() {
    return book;
  }
  public void setBook(Book book) {
    this.book = book;
  }
  public Member getEmployee() {
    return employee;
  }
  public void setEmployee(Member employee) {
    this.employee = employee;
  }
  public Date getBorrowDate() {
    return borrowDate;
  }
  public void setBorrowDate(Date borrowDate) {
    this.borrowDate = borrowDate;
  }
  public Date getReturnDate() {
    return returnDate;
  }
  public void setReturnDate(Date returnDate) {
    this.returnDate = returnDate;
  }
  
}








