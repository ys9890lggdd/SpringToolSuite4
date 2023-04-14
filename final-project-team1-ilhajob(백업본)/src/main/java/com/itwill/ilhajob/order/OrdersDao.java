package com.itwill.ilhajob.order;

import java.util.List;

public interface OrdersDao {
	
	Orders findByNo(int orderNo) throws Exception;
	
	Orders findProduct(int pNo) throws Exception;
	
	List<Orders> findAllBySeq(int userSeq) throws Exception;
	
	int update(Orders orders) throws Exception;
	
	int delete(int orderNo) throws Exception;
	
	boolean existOrders(char orderValid) throws Exception;
	  
}
