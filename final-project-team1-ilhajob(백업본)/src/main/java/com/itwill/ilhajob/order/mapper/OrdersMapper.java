package com.itwill.ilhajob.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.order.Orders;
import com.itwill.ilhajob.product.Product;

@Mapper
public interface OrdersMapper {
	
	public Orders selectByNo(int orderNo);
	
	public Orders selectProductByNo(int pNo);
	
	public List<Orders> selectAllBySeq(int userSeq);
	
	public int insertOrders(Orders orders);
	
	public int deleteOrders(int orderNo);
	
	public int existedOrders(char orderValid);

}
