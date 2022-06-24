package com.agenda.contactos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.contactos.modelo.Entities.Contacto;

public interface ContactoRepositorio extends JpaRepository<Contacto, Integer>{

}
