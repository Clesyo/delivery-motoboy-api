package br.com.motoboy.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.motoboy.delivery.interfaces.IOrderService;
import br.com.motoboy.delivery.models.Order;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

	@Autowired
	private IOrderService orderService;
	
	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public Order getOrder(@PathVariable Long id) {
		return orderService.getOrder(id);
	}
}
