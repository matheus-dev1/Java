package br.com.alura.forum.modelo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String senha;

	// Um usuario pode ter varios perfis e um Perfil pode estar atrelado a mais de um usuario.
	@OneToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<>();

	public Usuario() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return perfis;
	}

	@Override
	// Retorna a senha do usuario.
	public String getPassword() {
		return this.senha;
	}

	@Override
	// Retorna o nome de idenificação do usuario.
	public String getUsername() {
		return this.email;
	}

	@Override
	// Metodo que pergunta se a conta NÃO esta inspirada, ou seja, se a conta possui algum tipo de
	// validador que testa se a conta ta inspirada, exemplo uma mensalidade não paga.
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	// Se a conta NÃO está trancada, ou seja, se por algum mutivo(lógica) esta conta não está bloqueada.
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	// As credenciais deste usuario NÃO estão expiradas.
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	// A conta habilitada?
	public boolean isEnabled() {
		return true;
	}

}
