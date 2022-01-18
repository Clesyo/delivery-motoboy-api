package br.com.motoboy.delivery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.motoboy.delivery.models.ApiConfig;
import br.com.motoboy.delivery.repository.ApiConfigRepository;
import br.com.motoboy.delivery.utils.Utils;

@Component
public class DeliveryMotoboyApiContext {

	private ApiConfig apiConfig;

	@Autowired
	private ApiConfigRepository apiConfigRepository;

	public void load() {
		loadApiConfig();
	}

	private void loadApiConfig() {
		List<ApiConfig> configs = apiConfigRepository.findAll();

		if (configs.size() > 0) {
			apiConfig = configs.get(0);
		} else {
			apiConfig = new ApiConfig();
			apiConfig.setJwtExpirationInMinutes(20);
			apiConfig.setJwtSecret(Utils.generateRandomString(200));

			apiConfigRepository.save(apiConfig);
		}

		Utils.setContext(this);
	}

	public ApiConfig getApiConfig() {
		return apiConfig;
	}
}
