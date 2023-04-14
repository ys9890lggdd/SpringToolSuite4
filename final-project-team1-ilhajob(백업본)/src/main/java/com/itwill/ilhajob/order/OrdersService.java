package com.itwill.ilhajob.order;

import java.util.List;

public interface OrdersService {
	
	//주문번호로 1개의 주문정보 불러오기
    Orders selectByNo(int orderNo) throws Exception;
    
    //상품번호로 1개의 주문정보 불러오기
    Orders selectProductByNo(int pNo) throws Exception;
    
    //유저시퀸스로 주문리스트 불러오기
    List<Orders> selectAllBySeq(int userSeq) throws Exception;
      
    //insert orders
    int updateOrders(Orders orders) throws Exception;
    
    //delete orders
    int deleteOrders(int orderNo) throws Exception;
    
    //상품구매 목록 확인시 order_valid로 만료 표시
    boolean existedOrders(char orderValid) throws Exception;

}
