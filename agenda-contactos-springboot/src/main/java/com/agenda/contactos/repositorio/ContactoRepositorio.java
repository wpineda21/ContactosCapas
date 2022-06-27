package com.agenda.contactos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenda.contactos.modelo.Entities.Contacto;

@Repository
public interface ContactoRepositorio extends JpaRepository<Contacto, Integer>{

}
