package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Member;
import com.examly.springapp.service.MemberService;
@RestController
@RequestMapping("/api/members")
public class MemberController {

  @Autowired
  private MemberService service;

  @PostMapping
  public ResponseEntity<Member> addMember(@RequestBody Member mem) {
    return new ResponseEntity<>(service.addMember(mem), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Member>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Member> getMem(@PathVariable long id) {
    Member res=service.getMem(id);
    if(res==null)
    {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(res);
  }

  @PutMapping("/{memberId}")
  public ResponseEntity<Member> updateMember(@PathVariable long memberId,
                        @RequestBody Member updated) {
    return ResponseEntity.ok(service.updateMember(memberId, updated));
  }

  @GetMapping("phone/{phone}")
  public ResponseEntity<?> getPhone(@PathVariable String phone)
  {
    List<Member> res=service.getPhone(phone);
    if(res.isEmpty())
    {
      return new ResponseEntity<>("No member found with phone: 9999999999",HttpStatus.NO_CONTENT);
    }
    return ResponseEntity.ok(res);
  }

  @GetMapping("/email/{email}")
  public ResponseEntity<List<Member>> getMail(@PathVariable String email)
  {
    return ResponseEntity.ok(service.getMail(email));
  }

}


