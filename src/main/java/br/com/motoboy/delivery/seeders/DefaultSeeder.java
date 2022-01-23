package br.com.motoboy.delivery.seeders;

import static br.com.motoboy.delivery.enums.UserType.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.motoboy.delivery.models.User;
import br.com.motoboy.delivery.repository.RoleRepository;
import br.com.motoboy.delivery.repository.UserRepository;
import br.com.motoboy.delivery.utils.Utils;

@Service
public class DefaultSeeder {

	@Autowired
	private RoleRepository roleRopositoty;

	@Autowired
	private UserRepository userRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultSeeder.class);

	public void seedUser() {

		if (userRepository.findAll().size() == 0) {
			LOGGER.info(">>> Creating default user");
			User user = new User();
			user.setEmail("admin@gmail.com");
			user.setName("Admin User");
			user.setPassword(new BCryptPasswordEncoder().encode("123456"));
			roleRopositoty.findByName(ADMIN.name()).ifPresent(role -> user.setRole(role));
			userRepository.save(user);
			LOGGER.info("Default user created <<<");
		}
	}

	public void seedProfiles() {
		if (roleRopositoty.count() == 0) {
			LOGGER.info(">>> Creating default roles");
			Utils.convertUserTypeRoles(ADMIN, MOTOBOY).forEach(type -> roleRopositoty.save(type));
			LOGGER.info("Default roles created <<<");
		}
	}

}
