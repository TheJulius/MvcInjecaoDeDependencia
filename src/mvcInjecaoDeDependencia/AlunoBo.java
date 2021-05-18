package mvcInjecaoDeDependencia;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class AlunoBo {
	
	public boolean create (AlunoDto aluno) throws TransformerException, ParserConfigurationException, Exception {
		if(aluno.getCpf().length() != 0 ) {
			return aluno.persistencia.Create(aluno);
		}
		return false;
	}
	
	public boolean read (AlunoDto aluno) throws TransformerException, ParserConfigurationException, Exception {
		if(aluno.getCpf().length() != 0 ) {
			return aluno.persistencia.Read(aluno) != null;
		}
		return false;
	}
	
	public boolean update (AlunoDto aluno) {
		if(aluno.getCpf().length() != 0 ) {
			return aluno.persistencia.Update(aluno);	
		}
		return false;
	}
	
	public boolean delete (AlunoDto aluno) {
		if(aluno.getCpf().length() != 0 ) {
			return aluno.persistencia.Delete(aluno);	
		}
		return false;
	}

}
	