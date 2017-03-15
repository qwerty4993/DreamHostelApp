package com.ewaves.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ewaves.entities.LoginDetails;
import com.ewaves.repository.LoginRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	public LoginRepository loginRepository;

	@Autowired
	public CustomUserDetailsService(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		LoginDetails user = null;

		try {
			user = loginRepository.findByUsername(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (user == null) {
			throw new UsernameNotFoundException(String.format("User %s does not exist!", userName));
		}

		return new UserRepositoryUserDetails(user);
	}

	private final static class UserRepositoryUserDetails extends LoginDetails implements UserDetails {

		private static final long serialVersionUID = 1L;

		private UserRepositoryUserDetails(LoginDetails user) {
			super(user);
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
			roles.add(new GrantedAuthority() {
				private static final long serialVersionUID = 50178544382554480L;

				@Override
				public String getAuthority() {
					return getRole().getName();
				}
			});
			return roles;
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}

	}

}
