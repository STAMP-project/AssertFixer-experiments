package dev.repositories.concours;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.entites.Concours;

@Repository
public class ConcoursRepositoryDataJpa implements ConcoursRepository{

	private ConcourDataJpaRepo concourDataJpaRepo;
	
	public ConcoursRepositoryDataJpa(ConcourDataJpaRepo concourDataJpaRepo) {
		this.concourDataJpaRepo = concourDataJpaRepo;
	}
	
	@Override
	public List<Concours> findAll() {
		return concourDataJpaRepo.findAll();
	}

	@Override
	public void save(Concours entite) {
		concourDataJpaRepo.save(entite);
		
	}

	@Override
	public void update(Concours entiteAvecId) {
		if(concourDataJpaRepo.existsById(entiteAvecId.getId())){
			save(entiteAvecId);
		}
		
	}

	@Override
	public void delete(Concours entite) {
		concourDataJpaRepo.delete(entite);
		
	}

	@Override
	public Optional<Concours> findById(Long id) {
		return concourDataJpaRepo.findById(id);
	}

}
