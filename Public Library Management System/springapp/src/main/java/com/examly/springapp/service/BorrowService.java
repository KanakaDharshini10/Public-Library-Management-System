package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Borrow;
import com.examly.springapp.repository.BorrowRepo;

@Service
public class BorrowService {

  @Autowired
  private BorrowRepo repo;

  public String updateBorrow( long borrowId, Borrow updated)
  {
    Borrow existing =repo.findById(borrowId).orElse(null);
    if(existing==null)
    {
    return "No records found with the id you have provided";
    }
    existing.setBook(updated.getBook());
    existing.setEmployee(updated.getEmployee());
    existing.setBorrowDate(updated.getBorrowDate());
    existing.setReturnDate(updated.getReturnDate());

    repo.save(existing);
    return "Student Record updated successfully";
  }

}




