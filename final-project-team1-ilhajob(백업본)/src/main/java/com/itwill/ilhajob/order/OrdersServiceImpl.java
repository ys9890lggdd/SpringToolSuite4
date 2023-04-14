package com.itwill.ilhajob.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService{
	
	@Autowired
	private OrdersDao ordersDao;
	
	//constructor
	public OrdersServiceImpl(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}
	
	//getter
	public OrdersDao getOrdersDao() {
		return ordersDao;
	}
	
	//setter
	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}
	
	//OrderNo로 주문내역 1개의 리스트 불러오기
			@Override
			public Orders selectByNo(int orderNo) throws Exception {
				return ordersDao.findByNo(orderNo);
    }
		
	//ProductNo로 주문내역 1개의 리스트 불러오기
	@Override
	public Orders selectProductByNo(int pNo) throws Exception {
		return ordersDao.findProduct(pNo);
	}
	
	//UserSeq로 주문내역 리스트 모두 불러오기
	@Override
	public List<Orders> selectAllBySeq(int userSeq) throws Exception {
		return ordersDao.findAllBySeq(userSeq);
	}
		
	//insert orders
	@Override
	public int updateOrders(Orders orders) throws Exception {
		return ordersDao.update(orders);
	}
	
	//delete orders
	@Override
	public int deleteOrders(int orderNo) throws Exception {
		return ordersDao.delete(orderNo);
	}
	
	//Order valid로 상품구매 목록 확인시 만료 표시 해야하는지는 확실치는 않음..
	@Override
	public boolean existedOrders(char orderValid) throws Exception {
		boolean isExist = ordersDao.existOrders(orderValid);
		if(isExist) {
			return true;
		}else {
			return false;
		}
	}
	
}
