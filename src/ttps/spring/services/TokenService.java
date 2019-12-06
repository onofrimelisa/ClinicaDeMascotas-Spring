package ttps.spring.services;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import ttps.spring.model.dto.PayloadDTO;

@Service
public class TokenService {
	
	final static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	
    public String generateToken(PayloadDTO payload, int segundos) {
        Date exp = getExpiration(new Date(), segundos);

        return Jwts.builder()
        		.claim("usuario", payload.getUsuario())
        		.claim("roles", payload.getRoles())
        		.signWith(key)
        		.setExpiration(exp)
        		.compact();
    }
    
    
    private Date getExpiration(Date date, int segundos) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // Configuramos la fecha que se recibe
        calendar.add(Calendar.SECOND, segundos);

        return calendar.getTime();
    }

    public static boolean validateToken(String token) {

        String prefix = "Bearer";
        try {

            if (token.startsWith(prefix)) {
                token = token.substring(prefix.length()).trim();
            }

            Claims claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token).getBody();
            
            // obtener claims para generar payload y devolverlo
            
            return true;
        } catch (ExpiredJwtException exp) {
            System.out.println("El Token es valido, pero expiro su tiempo de validez");
            return false;
        } catch (JwtException e) {
            // Algo salio mal en la verificacion
            System.out.println("Error: " + e.getMessage());
            return false;
        }

    }
}
