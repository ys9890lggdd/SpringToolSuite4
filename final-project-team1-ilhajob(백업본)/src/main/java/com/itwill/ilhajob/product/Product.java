package com.itwill.ilhajob.product;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.itwill.ilhajob.order.Orders;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class Product {
	
	private int pNo;
	
	private String pName;
	
	private int pPrice;
	
	private int pEndMonth;
	
	private String pImage;
	
	private String pDiv;
	
	private List<Orders> orderList;
}
