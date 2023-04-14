package com.itwill.ilhajob.payment;

import java.util.Date;
import java.util.List;

import com.itwill.ilhajob.order.Orders;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Payment {
	private int paySeq;
	private int orderNo;
	private int payPrice;
	private String payMethod;
	private Date date;	
	private List<Orders> orderList;

}
