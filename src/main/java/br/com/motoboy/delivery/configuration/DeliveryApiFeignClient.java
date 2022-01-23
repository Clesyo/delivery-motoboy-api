package br.com.motoboy.delivery.configuration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.motoboy.delivery.models.Order;

@Component
@FeignClient(name = "delivery-api", path = "/order")
public interface DeliveryApiFeignClient {

	@GetMapping("/{id}")
	Order findById(@PathVariable Long id);
}
