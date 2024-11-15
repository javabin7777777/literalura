package com.samzubeli.literalura.model.dadosDB.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samzubeli.literalura.model.dadosDB.AutorDB;

public interface IAutorDBRepository extends JpaRepository<AutorDB, UUID> {

}
