package com.itwill.sns.naver;

import java.math.BigInteger;

public class ProductBuilderMain {

	public static void main(String[] args) {
		Product product1=new Product(1, "TV",BigInteger.valueOf(412343232423423L));
				
		Product product2=
				Product.builder()
				.no(1)
				.name("COMPUTER")
				.price(BigInteger.valueOf(21321321321L))
				.build();
		System.out.println(product1);
		System.out.println(product2);
	}

}
