package com.itwill.jpa.relation.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Category;
import com.itwill.jpa.relation.entity.Product;
import com.itwill.jpa.relation.entity.ProductDetail;
import com.itwill.jpa.relation.entity.Provider;

class ProductRepositoryTest extends SpringJpaRelationApplicationTests{
	
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductDetailRepository productDetailRepository;
	
	@Autowired
	ProviderRepository providerRepository;
	@Autowired
	CategoryRepository categoryRepository;

	//@Test
	void productSaveAndUpdate() {
		Product product=Product.builder()
						.name("JPA일주일만하면")
						.price(3000)
						.stock(1000)
						.build();
		productRepository.save(product);
		
		product.setName("JSP하루만하면");
		productRepository.save(product);
	}
	
	//@Test
	void productProductDetailSaveRead() {
		
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
			System.out.println("Product:"+productRepository.findById(1L).get());
			System.out.println("Product --> ProductDetail:"+productRepository.findById(1L).get().getProductDetail());
			
		}
	//@Test
	void productProviderSaveRead() {
		Provider provider=new Provider();
		provider.setName("삼성출판사");
		providerRepository.save(provider);
		
		Product product1=new Product();
		product1.setName("삼성책1");
		product1.setPrice(9000);
		product1.setStock(100);
		
		Product product2=new Product();
		product2.setName("삼성책2");
		product2.setPrice(4500);
		product2.setStock(12);
		
		/******연관설정 Product-->Provider******/
		product1.setProvider(provider);
		product2.setProvider(provider);
		/**************************************/
		productRepository.save(product1);
		productRepository.save(product2);
		
		/******연관설정 Provider-->Product******/
		//provider.getProductList().addAll(Arrays.asList(product1,product2));
		providerRepository.save(provider);
	
		System.out.println("Product:"+productRepository.findById(2L).get());
		System.out.println("Product --> Provider:"+productRepository.findById(2L).get().getProvider());
		System.out.println("Product --> Provider --> ProductList :"+productRepository.findById(2L).get().getProvider().getProductList());
	}
	
	
	@Test
	void productCategorySaveAndRead() {
		/*****case1[ManyToOne]******/
		Category category=new Category("C1","컴퓨터");
		categoryRepository.save(category);
		
		Product product1 =  Product.builder().name("EXCEL").price(5000000).stock(100).build();
		Product product2 =  Product.builder().name("WORD").price(5000000).stock(100).build();
		Product product3 =  Product.builder().name("POWERPOINT").price(5000000).stock(100).build();
		
		product1.setCategory(category);
		product2.setCategory(category);
		product3.setCategory(category);
		
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		
		System.out.println("---------------------------read---------------------------------");
		System.out.println("Product:"+productRepository.findById(3L).get());
		System.out.println("Product--> Category:"+productRepository.findById(3L).get().getCategory());
		System.out.println("Product--> Category --> ProductList :"+productRepository.findById(3L).get().getCategory().getProducts());
		/********************************/
	}
	
	
	
	
	
	
	
	
	
}