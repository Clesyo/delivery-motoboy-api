package br.com.motoboy.delivery.interfaces;

import br.com.motoboy.delivery.models.Order;

public interface IOrderService {

	Order getOrder(Long id);
}
