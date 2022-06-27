package com.agenda.contactos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.agenda.contactos.Services.ContactoService;
import com.agenda.contactos.modelo.DTOS.ContactoDTO;
import com.agenda.contactos.modelo.Entities.Contacto;
import com.agenda.contactos.repositorio.ContactoRepositorio;

@Controller
public class ContactoControlador {

	@Autowired
	private ContactoRepositorio contactoRepositorio;

	@Autowired
	private ContactoService contactoService;

	@GetMapping({"/",""})
	public String verPaginaDeInicio(Model modelo) {
		List<Contacto> contactos = contactoRepositorio.findAll();
		modelo.addAttribute("contactos", contactos);
		return "index";
	}
	
	@ModelAttribute("contacto")
	public ContactoDTO retornarNuevoUsuarioRegistroDTO() {
		return new ContactoDTO();
	}

	@GetMapping("/nuevo")
	public String mostrarFormularioDeRegistrarContacto(Model modelo) {
		modelo.addAttribute("contacto", new ContactoDTO());
		return "nuevo";
	}

	@PostMapping("/nuevo")
	public String guardarContacto(@Validated ContactoDTO contactoDTO,BindingResult bindingResult,RedirectAttributes redirect,Model modelo) {
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("contacto", contactoDTO);
			return "nuevo";
		}
		
		contactoService.guardarContacto(contactoDTO);
		redirect.addFlashAttribute("msgExito", "El contacto ha sido agregado con exito");
		return "redirect:/";
	}

	
	@GetMapping("/{id}/editar")
	public String mostrarFormularioDeEditarContacto(@PathVariable Integer id,Model modelo) {
		Contacto contacto = contactoRepositorio.getById(id);
		modelo.addAttribute("contacto", contacto);
		return "nuevo";
	}
	
	@PostMapping("/{id}/editar")
	public String actualizarContacto(@PathVariable Integer id,@Validated ContactoDTO contactoDTO,BindingResult bindingResult,RedirectAttributes redirect,Model modelo) {
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("contacto", contactoDTO);
			return "nuevo";
		}
		contactoService.EditarContacto(id, contactoDTO);
		redirect.addFlashAttribute("msgExito", "El contacto ha sido actualizado correctamente");
		return "redirect:/";
	}
	
	@PostMapping("/{id}/eliminar")
	public String eliminarContacto(@PathVariable Integer id,RedirectAttributes redirect) {
		Contacto contacto = contactoRepositorio.getById(id);
		contactoRepositorio.delete(contacto);
		redirect.addFlashAttribute("msgExito", "El contacto ha sido eliminado correctamente");
		return "redirect:/";
	}
}
