package br.com.motoboy.delivery.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.motoboy.delivery.configuration.security.jwt.JwtService;
import br.com.motoboy.delivery.dto.MessageDto;
import br.com.motoboy.delivery.dto.TokenDto;
import br.com.motoboy.delivery.dto.UserDto;
import br.com.motoboy.delivery.form.CredentialForm;
import br.com.motoboy.delivery.models.User;
import br.com.motoboy.delivery.repository.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtService jwtService;
	private PasswordEncoder encode = new BCryptPasswordEncoder();

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		return userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Não foi encontrado usuário com email informado."));
	}

	public ResponseEntity<Object> authenticate(@Valid CredentialForm form) {

		return authenticateUser(form);
	}

	private ResponseEntity<Object> authenticateUser(CredentialForm form) {
		try {
			UserDetails user = loadUserByUsername(form.getEmail());
			boolean isValidPassword = encode.matches(form.getPassword(), user.getPassword());
			if (isValidPassword) {

				String token = jwtService.generateToken(user);
				return ResponseEntity.ok(new TokenDto(token, "Bearer"));
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(
					new MessageDto("Email ou senha informada estão incorretos. Verifique os dados e tente novamente."),
					HttpStatus.UNAUTHORIZED);
		}

	}

	public ResponseEntity<Object> me(String token){
		
		String login = jwtService.obtainLoginUser(token);
		Optional<User> user = userRepository.findByEmail(login);
		return ResponseEntity.ok(UserDto.convert(user.get()));
	}
}
