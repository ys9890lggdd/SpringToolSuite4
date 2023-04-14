package com.itwill.ilhajob.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.ilhajob.order.OrdersService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrdersService ordersService;
	
	@RequestMapping("/shop")
	public String shop_list(@RequestParam("pDiv") String pDiv, Model model) throws Exception{
		List<Product> shopList = productService.selectAllByDiv(pDiv);
		model.addAttribute("shopList", shopList);
		String forward_path="shop";
		
		return forward_path;
		
		
	}
}
