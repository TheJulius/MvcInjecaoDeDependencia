package mvcInjecaoDeDependencia;

import java.io.FileNotFoundException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.json.simple.parser.ParseException;

public class Persistencia {
	
	public boolean Create(AlunoDto aluno) throws TransformerException, ParserConfigurationException, Exception { return true; }
	
	public AlunoDto Read(AlunoDto aluno) throws ParserConfigurationException, ParseException, FileNotFoundException { return null; }

	public boolean Update(AlunoDto aluno) { return true; }

	public boolean Delete(AlunoDto aluno) { return true; }

}
