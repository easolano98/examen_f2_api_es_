package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void ingresar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	public List<Estudiante> buscarEstudiante() {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante>MyQ=this.entityManager.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
		return MyQ.getResultList();
	}
	

}
