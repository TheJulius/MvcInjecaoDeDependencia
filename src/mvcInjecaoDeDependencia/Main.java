package mvcInjecaoDeDependencia;

import javax.xml.parsers.ParserConfigurationException;

public class Main {

	public static void main(String[] args) throws ParserConfigurationException, Exception {
		
		Persistencia persCsv = new PersistenciaCsv();
		Persistencia persJson = new PersistenciaJson();
		Persistencia persXml = new PersistenciaXml();
		
		AlunoDto a = new AlunoDto(persCsv,"Julio Cesar", "1", "12345678910", "15/02/1997", "juliocswin@gmail.com");
		AlunoBo abo = new AlunoBo();
		System.out.println(abo.create(a));
		System.out.println(abo.read(a));
		System.out.println(a);
		
		AlunoDto b = new AlunoDto(persJson, "Julia Cesar", "2", "12345678911", "16/02/1997", "juliacswin@gmail.com");
		AlunoBo bbo = new AlunoBo();
		System.out.println(bbo.create(b));
		System.out.println(bbo.read(b));
		System.out.println(b);

		AlunoDto c = new AlunoDto(persXml, "Juliano Cesar", "3", "12345678912", "17/02/1997", "julianocswin@gmail.com");
		AlunoBo cbo = new AlunoBo();
		System.out.println(cbo.create(c));
		System.out.println(cbo.read(c));
		System.out.println(c);
	}

}
