package mvcInjecaoDeDependencia;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;

public class PersistenciaXml extends Persistencia {
	
	private static File file = new File("aluno.xml");
	
	public void salvarDados(AlunoDto aluno) throws Exception {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		Element tagAluno = doc.createElement("Aluno");
		Element nome = doc.createElement("nome");
		Element matricula = doc.createElement("matricula");
		Element cpf = doc.createElement("cpf");
		Element dataNascimento = doc.createElement("dataNascimento");
		Element email = doc.createElement("email");
		
		nome.setTextContent(aluno.getNome());
		matricula.setTextContent(String.valueOf(aluno.getMatricula()));
		cpf.setTextContent(aluno.getCpf());
		dataNascimento.setTextContent(aluno.getDataNascimento());
		email.setTextContent(aluno.getEmail());
		
		tagAluno.appendChild(nome);
		tagAluno.appendChild(matricula);
		tagAluno.appendChild(cpf);
		tagAluno.appendChild(dataNascimento);
		tagAluno.appendChild(email);

		String arquivo = converter(doc);
		Create(arquivo);
	}
	
	private static String converter(Document document) throws TransformerException {

		Transformer transformer = TransformerFactory.newInstance().newTransformer();

		transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		StreamResult result = new StreamResult(new StringWriter());
		DOMSource source = new DOMSource(document);
		transformer.transform(source, result);

		String xmlString = result.getWriter().toString();

		return xmlString;
	}

    private static void Create(String documento) throws Exception {
        FileOutputStream fos = new FileOutputStream(file, true);
        fos.write(documento.getBytes());
        fos.flush();
        fos.close();
    }
    
	public AlunoDto Read() {
		return null;	
	}

}
