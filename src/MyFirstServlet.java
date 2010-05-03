import java.io.IOException;
import java.io.PrintWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


/**
 * Servlet implementation class MyFirstServlet
 */
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String FS = System.getProperty("file.separator");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		TransformerFactory tFactory = TransformerFactory.newInstance();
		
		// Use the TransformerFactory to instantiate a Transformer that will work with  
		// the stylesheet you specify. This method call also processes the stylesheet
	  // into a compiled Templates object.
		Transformer transformer = null;
		String ctx = getServletContext().getRealPath("") + FS;
		try {
		     Source xmlSource = new StreamSource(new URL("file", "", ctx+"stockAssociates.xml").openStream());
		     Source xslSource = new StreamSource(new URL("file", "", ctx+"transformation.xsl").openStream());
		     transformer = tFactory.newTransformer(xslSource);
		     transformer.transform(xmlSource, new StreamResult(writer));
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Use the Transformer to apply the associated Templates object to an XML document
		// (foo.xml) and write the output to a file (foo.out).
		
		

		
	/*	
		writer.println("<html>");
		writer.println("<head><title>Hello World!</title></head>");
		writer.println("<body>");
		writer.println("	<h1>Transformation is written to 'sourceOut.txt'</h1>");
		writer.println("<body>");
		writer.println("</html>");
		writer.close();
	*/	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
