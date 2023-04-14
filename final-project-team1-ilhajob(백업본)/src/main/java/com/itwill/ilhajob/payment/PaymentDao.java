package com.itwill.ilhajob.payment;

import java.util.List;

public interface PaymentDao {
	
	Payment findByNo(int paySeq) throws Exception;
	
	Payment findOrders(int orderNo) throws Exception;
	
	List<Payment> findAll() throws Exception;
	
	int insert(Payment payment) throws Exception;
	
	int delete(int paySeq) throws Exception;

}
