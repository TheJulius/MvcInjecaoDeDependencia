package mvcInjecaoDeDependencia;

import java.io.FileNotFoundException;

import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.parser.ParseException;

public class AlunoDto extends PessoaDto {
	
	private String matricula;
	private String cpf;
	private String dataNascimento;
	private String email;
	protected Persistencia persistencia;
	
	public AlunoDto() {
		
	}
	
	public AlunoDto(
			Persistencia persistencia,
			String nome, 
			String matricula, 
			String cpf, 
			String dataNascimento, 
			String email) 
	{
		super.setNome(nome);
		this.persistencia = persistencia;
		this.matricula = matricula;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		if(matricula.length() != 0)
			this.matricula = matricula;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if(cpf.length() != 0)
			this.cpf = cpf;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		if(dataNascimento != null)
			this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email.length() != 0)
			this.email = email;
	}
	
	public void Create(AlunoDto aluno) throws ParserConfigurationException, Exception {
		this.persistencia.Create(aluno);
	}
	
	public AlunoDto Read(AlunoDto aluno) throws ParseException, FileNotFoundException, ParserConfigurationException {
		return this.persistencia.Read(aluno);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Aluno [matricula=");
		builder.append(matricula);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", dataNascimento=");
		builder.append(dataNascimento);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
}
