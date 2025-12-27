package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examly.springapp.model.Borrow;
import com.examly.springapp.service.BorrowService;

@RequestMapping
public class BorrowController {

  @Autowired
  private BorrowService service;

  @PutMapping("/{borrowId}")
  public String updateBorrow(@PathVariable("borrowId") int borrowId, @RequestBody Borrow updated)
  {
    return service.updateBorrow(borrowId,updated);
  }
}





