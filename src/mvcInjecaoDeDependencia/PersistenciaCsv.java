package mvcInjecaoDeDependencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PersistenciaCsv extends Persistencia {
	
	public boolean Create(AlunoDto aluno) {
		
		try (PrintWriter writer = new PrintWriter(new File("aluno.csv"))) {

		      StringBuilder sb = new StringBuilder();
		      sb.append(aluno.getNome());
		      sb.append(',');
		      sb.append(aluno.getMatricula());
		      sb.append(',');
		      sb.append(aluno.getCpf());
		      sb.append(',');
		      sb.append(aluno.getDataNascimento());
		      sb.append(',');
		      sb.append(aluno.getEmail());
		 
		      writer.write(sb.toString());
		      
		      return true;

		    } catch (FileNotFoundException e) {
		      System.out.println(e.getMessage());
		    }
		return false;	
	}
	
	public AlunoDto Read() {
		return null;	
	}
}
