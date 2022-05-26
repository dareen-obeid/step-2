package com.dareen.web.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dareen.web.dto.ProductRepositry;
import com.dareen.web.model.Product;

@Service
public class ProductService {
	
	
	@Autowired
	private ProductRepositry productRepo;
	
	public void saveProductToDB(MultipartFile file, String code, String name, String description, 
			String productLine, int quantity, float price) {
		
		Product p = new Product();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")){
			
			System.out.println("not a valid file");
		}
		try {
			p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		 
		p.setProductCode(code);
		p.setProductName(name);
		p.setBuyPrice(price);
		p.setProductDescription(description);
		p.setProductLine(productLine);
		p.setQuantityInStock(quantity);
		
		productRepo.save(p);
	}

}
