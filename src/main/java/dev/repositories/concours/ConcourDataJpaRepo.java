package dev.repositories.concours;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entites.Concours;

public interface ConcourDataJpaRepo extends JpaRepository<Concours, Long>{

}
