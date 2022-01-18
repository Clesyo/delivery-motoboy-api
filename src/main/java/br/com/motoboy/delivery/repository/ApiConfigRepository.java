package br.com.motoboy.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.motoboy.delivery.models.ApiConfig;

public interface ApiConfigRepository extends JpaRepository<ApiConfig, Long>{

}
