package br.com.motoboy.delivery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.motoboy.delivery.enums.UserType;
import br.com.motoboy.delivery.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Optional<Role> findByName(UserType type);

}
