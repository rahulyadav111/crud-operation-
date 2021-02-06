package com.Controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.Controller.Dao.ProductDao;
import com.Controller.Model.Product;

//import org.springframework.web.servlet.DispatcherServlet;
@Controller
public class HomeController
{
	@Autowired
	private ProductDao productDao; //from autowired obj will automatically inject in controller from productDao 
	
	
	@RequestMapping("/home")
	public String view(Model m)
	{
		
	List<Product> products=	productDao.getProducts();
	m.addAttribute("product", products);
		return "home";
	}

	/* show add product form */
	@RequestMapping("/addProduct")
	public String addProduct(Model m )
	{
		m.addAttribute("title", "Add product.");
		return "addProduct";
	}
	
//	handle add produt form
	@RequestMapping(value="/HandleProduct", method=RequestMethod.POST)
	public RedirectView HandleAddProduct(@ModelAttribute Product product,HttpServletRequest request)
	{
		System.out.println(product);
		productDao.createProduct(product);
		
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		
		return redirectView;
	}
	
	
	/* delele handler from here */
	
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId")int productId,HttpServletRequest request)
	{
	this.productDao.deleteProduct(productId);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		
		return redirectView;
	}
	@RequestMapping("/update/{productId}")
	public String updateForm(@PathVariable("productId")int pid,Model m)
	{
	Product product=this.productDao.getProduct(pid);
	m.addAttribute("product", product);
		return "updateForm";
		
	}
	
}
