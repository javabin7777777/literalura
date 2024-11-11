package com.samzubeli.literalura.model.dadosDB.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samzubeli.literalura.model.dadosDB.LivroPersistir;


public interface livroPersistirRepository extends JpaRepository<LivroPersistir, UUID> {

}
