package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.TO.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository repository;

	@Override
	public void registrar(EstudianteTO estudiante) {
		// TODO Auto-generated method stub
		this.repository.ingresar(this.transformar(estudiante));

	}

	@Override
	public List<EstudianteTO> mostrarRegistros() {
		// TODO Auto-generated method stub
		List<Estudiante>lista=this.repository.buscarEstudiante();
		List<EstudianteTO>lsTO=null;
		for(Estudiante e: lista) {
			lsTO= lista.stream().map(estudiante->this.transformarTO(e)).collect(Collectors.toList());
		}
		
		return lsTO;
	}

	public Estudiante transformar(EstudianteTO esTO) {

		Estudiante est = new Estudiante();

		est.setCedula(esTO.getCedula());
		est.setNombre(esTO.getNombre());
		est.setApellido(esTO.getApellido());

		return est;
	}

	public EstudianteTO transformarTO(Estudiante est) {

		EstudianteTO esTO = new EstudianteTO();

		esTO.setCedula(est.getCedula());
		esTO.setNombre(est.getNombre());
		esTO.setApellido(est.getApellido());

		return esTO;
	}

}
