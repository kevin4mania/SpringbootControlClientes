package com.kr.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.kr.demo.domain.Persona;

public interface PersonaDao extends CrudRepository<Persona, Long> {

}
