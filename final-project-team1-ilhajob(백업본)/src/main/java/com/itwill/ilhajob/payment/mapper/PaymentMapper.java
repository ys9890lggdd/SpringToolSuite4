package com.itwill.ilhajob.payment.mapper;

import java.util.List;

import com.itwill.ilhajob.payment.Payment;

public interface PaymentMapper {
	
	public Payment selectByNo(int paySeq);
	
	public Payment selectOrdersByNo(int orderNo);
	
	public List<Payment> selectAll();
	
	public int insertPayment(Payment payment);
	
	public int deletePayment(int paySeq);

}
