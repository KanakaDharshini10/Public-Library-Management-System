package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Member;

public interface MemberService 
{

  Member updateMember(long memberId , Member updated);

  Member addMember(Member mem);
  List<Member> findAll();
  Member getMem(long id);
  List<Member> getPhone(String phone);
  List<Member> getMail(String email);
}

