package mvcInjecaoDeDependencia;

public class PessoaDto {
	
	private String nome;
	
	public PessoaDto() {
		
	}
	
	public PessoaDto(String nome) {
		setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome.length()!= 0)
			this.nome = nome;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pessoa [nome=");
		builder.append(nome);
		builder.append("]");
		return builder.toString();
	}
}
