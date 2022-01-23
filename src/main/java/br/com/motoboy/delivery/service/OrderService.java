package br.com.motoboy.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.motoboy.delivery.configuration.DeliveryApiFeignClient;
import br.com.motoboy.delivery.interfaces.IOrderService;
import br.com.motoboy.delivery.models.Order;

@Service
public class OrderService implements IOrderService{
	
	@Autowired
	private DeliveryApiFeignClient deliveryApiFeignClient;

	@Override
	public Order getOrder(Long id) {
		// TODO Auto-generated method stub
		var order = deliveryApiFeignClient.findById(id);
		return order;
	}

	
}
