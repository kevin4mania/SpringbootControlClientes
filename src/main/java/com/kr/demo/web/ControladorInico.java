package com.kr.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.kr.demo.domain.Persona;
import com.kr.demo.servicio.PersonaService;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ControladorInico {
	private static Logger log = LoggerFactory.getLogger(ControladorInico.class);

	@Autowired
	private PersonaService personaService;

	@GetMapping("/")
	public String inicio(Model model, @AuthenticationPrincipal User user) {
		log.info("ejecutando el controlador spring mvc");
		log.info("Usuario logeado:" + user);
		var personas = personaService.listarPersonas();
		model.addAttribute("personas", personas);
		return "index";
	}

	@GetMapping("/agregar")
	public String agregar(Persona persona) {
		return "modificar";
	}

	@PostMapping("/guardar")
	public String guardar(@Valid Persona persona, Errors errores) {
		if (errores.hasErrors()) {
			return "modificar";
		}
		personaService.guardar(persona);
		return "redirect:/";
	}

	@GetMapping("/editar/{id}")
	public String editar(Persona persona, Model model) {
		log.info("ejecutando editar");
		persona = personaService.encontrarPersona(persona);
		model.addAttribute("persona", persona);
		return "modificar";
	}

	@GetMapping("/eliminar")
	public String eliminar(Persona persona) {
		log.info("ejecutando Eliminar");
		personaService.eliminar(persona);
		return "redirect:/";

	}

}
