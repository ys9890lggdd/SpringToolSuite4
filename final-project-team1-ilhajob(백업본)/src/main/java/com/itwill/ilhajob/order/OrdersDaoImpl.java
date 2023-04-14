package com.itwill.ilhajob.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.order.mapper.OrdersMapper;

@Repository
public class OrdersDaoImpl implements OrdersDao{
	
	@Autowired
	private OrdersMapper ordersMapper;
	
	@Override
	public Orders findByNo(int orderNo) throws Exception {
		return ordersMapper.selectByNo(orderNo);
	}
	
	@Override
	public Orders findProduct(int pNo) throws Exception {
		return ordersMapper.selectProductByNo(pNo);
	}
	
	@Override
	public List<Orders> findAllBySeq(int userSeq) throws Exception {
		return ordersMapper.selectAllBySeq(userSeq);
	}
			
	@Override
	public int update(Orders orders) throws Exception {
		return ordersMapper.updateOrders(orders);
	}
	
	@Override
	public int delete(int orderNo) throws Exception {
		return ordersMapper.deleteOrders(orderNo);
	}
	
	@Override
	public boolean existOrders(char orderValid) throws Exception {
		if(ordersMapper.existedOrders(orderValid)==1) {
			return true;
		}else {
			return false;
		}
	}

}
