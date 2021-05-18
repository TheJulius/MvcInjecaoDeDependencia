package mvcInjecaoDeDependencia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PersistenciaJson extends Persistencia {
	
	@SuppressWarnings("unchecked")
	public boolean Create(AlunoDto aluno) {
		
		JSONObject jsonObject = new JSONObject();
		FileWriter writeFile = null;

		jsonObject.put("nome", aluno.getNome());
		jsonObject.put("matricula", aluno.getMatricula());
		jsonObject.put("cpf", aluno.getCpf());
		jsonObject.put("dataNascimento", aluno.getDataNascimento());
		jsonObject.put("email", aluno.getEmail());
		
		try{
			writeFile = new FileWriter("aluno.json");
			writeFile.write(jsonObject.toJSONString());
			writeFile.close();
			
			return true;
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public AlunoDto Read() throws ParserConfigurationException, ParseException, FileNotFoundException 
	{
		
		JSONObject jsonObject = null;
		JSONParser parser = new JSONParser();
		
		String nome;
		String matricula;
		String cpf;
		String dataNascimento;
		String email;
		AlunoDto a = new AlunoDto();

		try {
			jsonObject = (JSONObject) parser.parse(new FileReader("aluno.json"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		nome = (String) jsonObject.get("nome");
		matricula = (String) jsonObject.get("matricula");
		cpf = (String) jsonObject.get("cpf");
		dataNascimento= (String) jsonObject.get("dataNascimento");
		email = (String) jsonObject.get("email");
		
		a.setNome(nome);
		a.setMatricula(matricula);
		a.setCpf(cpf);
		a.setDataNascimento(dataNascimento);
		a.setEmail(email);
		
		return a;
	}

}
