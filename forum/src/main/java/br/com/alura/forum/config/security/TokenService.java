package br.com.alura.forum.config.security;

import br.com.alura.forum.modelo.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${forum.jwt.expiration}")
    private String expiration;

    @Value("${forum.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication) {
        Usuario usuarioLogado = (Usuario) authentication.getPrincipal();
        Date dataCriacao = new Date();
        // Soma dos dois milisegundos e criar a data de expiração, que neste caso é um dia!
        Date dateExiracao = new Date(dataCriacao.getTime() + Long.parseLong(expiration));
        return Jwts.builder()
                // Quem é a aplicação que esta gerando o Token.
                .setIssuer("API do forum da Alura")
                // Usuario autenticado que este token pertence.
                .setSubject(usuarioLogado.getId().toString())
                // Data da criação do token
                .setIssuedAt(dataCriacao)
                // Tempo de expiração do token.
                .setExpiration(dateExiracao)
                // Algoritmo de criptografia e a senha da minha aplicação
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

	public boolean isTokenValido(String token) {
		// Nos retorna um objeto Jws<Claims> que é um objeto onde eu consigo recuperar o token e as 
		// informações que eu setei dentro do token.
		// Obs: Se o token estiver valido retorna o objeto se não retorna uma exception.
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception exception) {
			return false;
		}
	}

	public Long getIdUsuario(String token) {
		// Devolve o objeto do token.
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		// retorna o id do cliente em formato de long.
		return Long.parseLong(claims.getSubject());
	}

}
