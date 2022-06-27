package com.agenda.contactos.Services.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.contactos.Services.ContactoService;
import com.agenda.contactos.modelo.DTOS.ContactoDTO;
import com.agenda.contactos.modelo.Entities.Contacto;
import com.agenda.contactos.repositorio.ContactoRepositorio;

@Service
public class ContactoServiceImpl implements ContactoService {

    @Autowired
    private ContactoRepositorio contactoRepositorio;

    @Override
    public Contacto guardarContacto(ContactoDTO contactoDTO) {
        Contacto usuario = new Contacto(contactoDTO.getNombre(), contactoDTO.getCelular());
        return contactoRepositorio.save(usuario);
    }

    @Override
    public Contacto EditarContacto(Integer id, ContactoDTO contactoDTO) {

        Contacto contacto = contactoRepositorio.getById(id);

        contacto.setNombre(contactoDTO.getNombre());
        contacto.setCelular(contactoDTO.getCelular());

        return contactoRepositorio.save(contacto);
    }

}
