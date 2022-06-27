package com.agenda.contactos.Services;

import com.agenda.contactos.modelo.DTOS.ContactoDTO;
import com.agenda.contactos.modelo.Entities.Contacto;

public interface ContactoService {

    public Contacto guardarContacto(ContactoDTO contactoDTO);
    public Contacto EditarContacto(Integer id,ContactoDTO contactoDTO); 

    
}
