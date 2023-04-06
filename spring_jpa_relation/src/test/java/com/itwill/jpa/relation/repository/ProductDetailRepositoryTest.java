package com.itwill.jpa.relation.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Product;
import com.itwill.jpa.relation.entity.ProductDetail;

class ProductDetailRepositoryTest extends SpringJpaRelationApplicationTests{
	@Autowired
	ProductDetailRepository productDetailRepository;
	@Autowired
	ProductRepository productRepository;
	
	@Test
	void productDetailProductSaveRead() {
		Product product=new Product();
		product.setName("스프링시큐리디변경");
		product.setPrice(80000);
		product.setStock(500);
		productRepository.save(product);
		
		ProductDetail productDetail=new ProductDetail();
		productDetail.setDescription("아주좋은책이여요!!!");
		productDetail.setProduct(product);
		productDetailRepository.save(productDetail);
		
		System.out.println("-----------------read--------------------");
		
		System.out.println(">>> ProductDetail: "+productDetailRepository.findById(2L).get());
		
		System.out.println(">>> ProductDeatil-->Product: "+productDetailRepository.findById(2L).get().getProduct());
		
	}
}
