package co.com.prodigious.services;

import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.com.prodigious.entities.UserEntity;
import co.com.prodigious.repositories.UsersRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UsersRepository usersRepository;

	public UserDetailsServiceImpl(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserEntity user = usersRepository.findByDocumentNumber(username);

		if (Objects.isNull(user) || Objects.isNull(user.getUserId())) {
			throw new UsernameNotFoundException("Username: " + username + " not found");
		}

		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN");

		return new User(user.getDocumentNumber(), user.getPassword(), grantedAuthorities);

	}

}
