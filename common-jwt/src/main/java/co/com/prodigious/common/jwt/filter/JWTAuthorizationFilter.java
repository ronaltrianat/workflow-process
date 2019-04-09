package co.com.prodigious.common.jwt.filter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import co.com.prodigious.common.jwt.provider.JwtTokenProvider;
import io.jsonwebtoken.Claims;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

	private JwtTokenProvider tokenProvider;
	
	public JWTAuthorizationFilter(JwtTokenProvider tokenProvider) {
		this.tokenProvider = tokenProvider;
	}
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		try {
			String jwt = getJwtFromRequest(request);
			
			if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
				Claims claims = tokenProvider.getClaimsFromJWT(jwt);
				String username = claims.getSubject();
				
				if (username != null) {

					@SuppressWarnings("unchecked")
					List<String> authorities = (List<String>) claims.get("authorities");

					UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null,
							authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));

					SecurityContextHolder.getContext().setAuthentication(auth);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			SecurityContextHolder.clearContext();
		}

		filterChain.doFilter(request, response);
	}

	private String getJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}
}
