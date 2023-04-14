package com.itwill.ilhajob.order;

import java.util.Date;
import java.util.List;

import com.itwill.ilhajob.payment.Payment;
import com.itwill.ilhajob.product.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Orders {
	private int orderNo;
	private Date orderEndDate;
	//상품구매 목록 확인시 order_valid로 만료 표시
	private char orderValid;
	private int pNo;
	private String corpId;
	private int userSeq;
	private Product product;	
	private List<Product> productList;		
	private List<Payment> paymentList;
}
