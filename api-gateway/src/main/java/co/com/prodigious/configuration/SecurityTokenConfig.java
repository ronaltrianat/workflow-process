package co.com.prodigious.configuration;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import co.com.prodigious.common.jwt.filter.JWTAuthorizationFilter;
import co.com.prodigious.common.jwt.provider.JwtTokenProvider;


@EnableWebSecurity
public class SecurityTokenConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
				.and().csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().exceptionHandling()
				.authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
				.and().addFilterAfter(new JWTAuthorizationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.and().authorizeRequests().antMatchers(HttpMethod.POST, "/auth/**").permitAll()
				.anyRequest().authenticated();
	}

}
