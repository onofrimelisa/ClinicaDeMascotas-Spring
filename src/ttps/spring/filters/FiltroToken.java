package ttps.spring.filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

import ttps.spring.services.TokenService;


@WebFilter("/api/*")
public class FiltroToken implements Filter{
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String token = ((HttpServletRequest)request).getHeader(HttpHeaders.AUTHORIZATION);
		HttpServletResponse res = (HttpServletResponse) response;
		
		System.out.println("Paso por filtro");
		System.out.println(token);
		
		if (token == null || !TokenService.validateToken(token)) {
        	Map<String, Object> error = new HashMap<>();
        	error.put("error", "Token inválido");
        	
        	res.setStatus(HttpStatus.BAD_REQUEST.value());
        	res.setContentType(MediaType.APPLICATION_JSON_VALUE);
        	
        	mapper.writeValue(res.getWriter(), error);
        }
    	
        chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
