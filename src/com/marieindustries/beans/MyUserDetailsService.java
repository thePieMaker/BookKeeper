package com.marieindustries.beans;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.marieindustries.dao.DAO;
import com.marieindustries.beans.*;
import java.util.*;
public class MyUserDetailsService implements UserDetailsService{
	private DAO dao = new DAO();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Note: we have a User bean, but there is a Spring User class as well, 
		// and we are required to specify which is which below
		com.marieindustries.beans.User user = dao.findByUserName(username);
		
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
		
		return buildUserForAuthentication(user, authorities);
	}
	
	// Converts ca.sheridancollege.beans.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(com.marieindustries.beans.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		
		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);
		return result;
	}

}
