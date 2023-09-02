package com.example.demo.service;

import java.util.List;

import com.example.demo.service.TO.EstudianteTO;

public interface IEstudianteService {
	
	public void registrar(EstudianteTO estudiante);
	
	public List<EstudianteTO>mostrarRegistros();
	
	
}
