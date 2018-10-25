package com.example.demo.daoo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Produit;

//@RepositoryRestResource
public interface ProduitRepository extends MongoRepository<Produit,Long> {
	
	
	//@Query("select p from Produit p where p.designation like:x")
	//public Page<Produit> ProduitParMotCle(@Param("x") String mc, Pageable p);

	public List<Produit> findByDesignation(String des);


	
	public Page<Produit> findByDesignation(String des, Pageable p);
	
}
