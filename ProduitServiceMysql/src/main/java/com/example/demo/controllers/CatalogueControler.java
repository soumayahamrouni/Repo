package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.daoo.ProduitRepository;
import com.example.demo.entities.Produit;

@RestController
public class CatalogueControler {

	//injection de l'interface pour utiliser ses methodes
	@Autowired
	private ProduitRepository produitrepository;

	
	@RequestMapping("/save")
	public Produit saveproduit(Produit p)
	{
		produitrepository.save(p);
		return p ;
	}
	
	@RequestMapping("/all")
	public List<Produit> getproduits(){
		
		return produitrepository.findAll();
	}
	@RequestMapping("/produits")
	public Page <Produit> getproduits(int page)
	{
		return produitrepository.findAll(new PageRequest(page,5));
		
	}
	
	//@RequestMapping("/ProduitParMotCle")
	//public Page<Produit> getproduits(String mc,int page)
	//{
		//return produitrepository.ProduitParMotCle("%"+mc+"%", new PageRequest(page,5));
//	}
	
	@RequestMapping("/get")
     public Produit getproduit(Long ref)
     {
		return produitrepository.findById(ref).orElse(null);
		
     }
	
	@RequestMapping("/delete")
    public void  delete(Long ref )
    {
		produitrepository.deleteById(ref);
    }
	
	//@RequestMapping("/update")
    //public Produit update(Produit p)
    //{
		
		//produitrepository.saveAndFlush(p);
		//return p;
    //}
	
}
