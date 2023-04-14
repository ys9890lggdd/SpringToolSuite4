package com.itwill.ilhajob.order;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootOrdersDaoMain {
	
	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext=
				SpringApplication.run(SpringBootOrdersDaoMain.class, args);
		OrdersDao ordersDao=(OrdersDao)applicationContext.getBean(OrdersDao.class);
		//System.out.println("--selectByNo--");
		//System.out.println(ordersDao.findByNo(5));
		
		//System.out.println("--selectProductByNo--");
		//System.out.println(ordersDao.findProduct(5));
		
		//System.out.println("--selectAllBySeq--");
		//System.out.println(ordersDao.findAllBySeq(1));
				
		//System.out.println("--insert--");
		//System.out.println(ordersDao.insert(Orders.builder()
		//		                                  .orderNo(9)
		//		                                  .orderEndDate(new Date())
		//		                                  .orderValid('F')
		//		                                  .pNo(6)
		//		                                  .corpId("corp_03")
		//		                                  .userSeq(1)
		//		                                  .build()));
		
		//System.out.println("--delete--");
		//System.out.println(ordersDao.delete(3));
		
		//System.out.println("--existOrders--");
		//System.out.println(ordersDao.existOrders('T'));
	}

}
