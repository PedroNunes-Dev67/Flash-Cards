package FlashBrain_Backend.security;

import FlashBrain_Backend.exceptions.ResourceUserException;
import FlashBrain_Backend.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    private String secret = "Chave-Secreta";

    public String generateToken(Usuario usuario){

        Algorithm algorithm = Algorithm.HMAC256(secret);

            try {
                return JWT
                        .create()
                        .withIssuer("auth-api")
                        .withSubject(usuario.getEmail())
                        .withExpiresAt(tokenExpired())
                        .sign(algorithm);
            }
            catch (JWTCreationException e){
                throw new ResourceUserException("Erro ao gerar Token");
            }
    }

    public String validateToken(String token){

        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        }
        catch (JWTVerificationException e){
            throw new ResourceUserException("Token inválido");
        }
    }

    private Instant tokenExpired(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
