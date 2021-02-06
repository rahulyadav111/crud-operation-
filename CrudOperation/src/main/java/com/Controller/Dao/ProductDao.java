package com.Controller.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.Controller.Model.Product;

@Component
public class ProductDao 
{
	@Autowired
	private HibernateTemplate hibernateTemplate;

	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional //use for create product 
	public void createProduct(Product product)
	{
	
		this.hibernateTemplate.saveOrUpdate(product);
	} 
	
	/*
	 * //get all product here
	 */	
	public List<Product> getProducts()
	{
	List<Product> products=	this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	/*
	 * //delte the single product here
	 */	
	@Transactional
	public void deleteProduct(int pid)
	{
		Product p=this.hibernateTemplate.load(Product.class, pid);
		this.hibernateTemplate.delete(p);
		
	}
	
	/* get the single product */
	
	public Product getProduct(int pid)
	{
			return this.hibernateTemplate.get(Product.class, pid);
		
	}
	
	
}
