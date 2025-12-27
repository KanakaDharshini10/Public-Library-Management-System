package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Member;
import com.examly.springapp.repository.MemberRepo;

@Service
public class MemberServiceImpl implements MemberService{

  @Autowired
  MemberRepo repo;

  @Override
  public Member updateMember(long memberId, Member updated) {
    Member existing =repo.findById(memberId).orElse(null);
    if(existing==null)
    {
      return null;
    }
    existing.setEmail(updated.getEmail());
    existing.setPhone(updated.getPhone());
    existing.setName(updated.getName());

    return repo.save(existing);  
  }

  @Override
  public Member addMember(Member mem) 
  {
    return repo.save(mem);
  }

  @Override
  public List<Member> findAll() 
  {
    return repo.findAll();
  }

  @Override
  public Member getMem(long id) 
  {
    return repo.findById(id).orElse(null);
  }

  @Override
  public List<Member> getPhone(String phone) 
  {
    return repo.findByPhone(phone);
  }

  @Override
  public List<Member> getMail(String email) 
  {
    return repo.findByEmail(email);
  }

  
}





