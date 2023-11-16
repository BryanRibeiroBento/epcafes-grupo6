package com.epcafes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.epcafes.model.Instalacao;
import com.epcafes.model.Propriedade;

@Repository
public interface InstalacaoRepository extends JpaRepository<Instalacao, Long>{
	@Query("SELECT i FROM Instalacao i "
			+ "WHERE i.propriedade = :propriedade")
	List<Instalacao> findAllByPropriedade(Propriedade propriedade);
}
