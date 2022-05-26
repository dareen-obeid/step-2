package com.dareen.web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dareen.web.dto.ProductRepositry;
import com.dareen.web.model.Product;
import com.dareen.web.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepositry productRepo;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/listProducts.html")
	public String showExampleVeiw(Model model) {
		List<Product> products = productRepo.findAll();
		model.addAttribute("products", products);
		

		return "/listProducts.html";
		
	}
	
	@GetMapping("/")
	public String showAddProduct() {
		
		return "/addProduct.html";
	}
	
	@PostMapping("/addp")
	public String saveProduct(
			@RequestParam("productCode") String productCode,
			@RequestParam("productName") String productName,
			@RequestParam("buyPrice") float buyPrice,
			@RequestParam("productDescription") String productDescription,
			@RequestParam("productLine") String productLine,
			@RequestParam("quantityInStock") int quantityInStock,
			@RequestParam("file") MultipartFile file) {
		
		productService.saveProductToDB(file, productCode, productName, productDescription, productLine, quantityInStock, buyPrice);
		

		
		return "redirect:/listProducts.html";
		
	}
	
	
	@GetMapping("/deleteProduct/{id}")
		public String deleteProduct(@PathVariable("id") String id) {
		
		productRepo.deleteById(id);
		
		return "redirect:/listProducts.html";
		
	}
	
	
	@PostMapping("/changeName")
	public String changePname(@RequestParam("productCode") String id,
	        @RequestParam("newPname") String name) {
		
		Product p = new Product();
		p = productRepo.findById(id).get();
		p.setProductName(name);
		productRepo.save(p);
		
		return "redirect:/listProducts.html";
	}
	
	
	@PostMapping("/changeDescription")
	public String changeDescription(@RequestParam("productCode") String id,
	        @RequestParam("newDescription") String des) {
		
		Product p = new Product();
		p = productRepo.findById(id).get();
		p.setProductDescription(des);	
		productRepo.save(p);
		
		return "redirect:/listProducts.html";
	}
	
	
	@PostMapping("/changeproductLine")
	public String changeproductLine(@RequestParam("productCode") String id,
	        @RequestParam("newproductLine") String productLine) {
		
		Product p = new Product();
		p = productRepo.findById(id).get();
		p.setProductLine(productLine);	
		productRepo.save(p);
		
		return "redirect:/listProducts.html";
	}

	@PostMapping("/changequantityInStock")
	public String changequantityInStock(@RequestParam("productCode") String id,
	        @RequestParam("newquantityInStock") int quantityInStock) {
		
		Product p = new Product();
		p = productRepo.findById(id).get();
		p.setQuantityInStock(quantityInStock);	
		productRepo.save(p);
		
		return "redirect:/listProducts.html";
	}

	@PostMapping("/changebuyPrice")
	public String changebuyPrice(@RequestParam("productCode") String id,
	        @RequestParam("newbuyPrice") float buyPrice) {
		
		Product p = new Product();
		p = productRepo.findById(id).get();
		p.setBuyPrice(buyPrice);	
		productRepo.save(p);
		
		return "redirect:/listProducts.html";
	}

	
	
	
	
	


}
