package br.com.alura.forum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.config.security.TokenService;
import br.com.alura.forum.controller.form.LoginForm;
import br.com.alura.forum.dto.TokenDTO;

@RestController
@RequestMapping("/auth")
// Eu posso definir mais de um profile para uma classe.
@Profile(value = {"prod", "test"})
public class AutenticacaoControler {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    // Metodo será chamando quando o cliente solicitar os dados de usuario e senha

    // Autenticação Stateless - O cliente dispara uma requisição, leva todas as informações necessárias,
    // o servidor processa, executa o que tem que executar, devolve a resposta e acabou.
    @PostMapping
    public ResponseEntity<TokenDTO> autenticar(@RequestBody @Valid LoginForm loginForm) {
        UsernamePasswordAuthenticationToken dadosLogin = loginForm.converter();
        try {
            Authentication authentication = authManager.authenticate(dadosLogin);
            
            String token = tokenService.gerarToken(authentication);
            
            // Obs: Para as proximas requisições "restritas" ou seja, que o usuario precisa estar logado
            // o Header Authorization precisa ser incluido junto com o valor "Bearer + token".
            System.out.println(token);
            
            /*
            	Existem alguns tipos de metodos de autenticação vou citar dois 
            	para exemplificar como Bearer e Basic.
            	
				O Bearer trafega um token no Header da requisição e o Basic um usuário e senha.
				
				Se tratando de JWT após o usuário efetuar login no sistema/api, você criar um token 
				(que pode ser manual ou utilizando libs como o https://github.com/jwtk/jjwt)
				
				São atributos não obrigatórios (mas recomendados) que são usados na validação do token pelos protocolos de segurança das APIs.

				sub (subject) = Entidade à quem o token pertence, normalmente o ID do usuário;
				iss (issuer) = Emissor do token;
				exp (expiration) = Timestamp de quando o token irá expirar;
				iat (issued at) = Timestamp de quando o token foi criado;
				aud (audience) = Destinatário do token, representa a aplicação que irá usá-lo.
            */
            
            return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
            
        } catch (AuthenticationException authenticationException) {
            return ResponseEntity.badRequest().build();
        }
    }
}
