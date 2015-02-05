package edu.uniandes.ecos;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * 
 * @author Jorge Alfonso Beltrán Sandoval
 * Clase realizada para imprimir datos por un servlet levantando un servivio en el puerto 5000
 *
 */

public class PrintWeb extends HttpServlet {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String mensaje;
	public LinkedList<String> classNames=new LinkedList<String>();
	public LinkedList<String> methodNames=new LinkedList<String>();
	public LinkedList<Integer> classLocs=new LinkedList<Integer>();
	public LinkedList<Integer> methodLocs=new LinkedList<Integer>();
	public int LOCcounter;
	
	@Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      showHome(req,resp);
	  }

	  private void showHome(HttpServletRequest req, HttpServletResponse resp)
	      throws ServletException, IOException {
		    resp.setContentType("text/html");
		    resp.getWriter().print("<table><tr><td>Nombre (Metodos,Clases) </td>");
			for(String value: classNames){
				resp.getWriter().print("<td>"+value+"</td>");
			}
			resp.getWriter().print("</tr><td>Numero de Lineas </td>");
			for(Integer value: classLocs){
				resp.getWriter().print("<td>"+value+"</td>");
			}
			resp.getWriter().print("</tr><td>Nombre (Metodos,Clases) </td>");
			for(String value: methodNames){
				resp.getWriter().print("<td>"+value+"</td>");
			}
			resp.getWriter().print("</tr><td>Numero de Lineas </td>");
			for(Integer value: methodLocs){
				resp.getWriter().print("<td>"+value+"</td>");
			}
			resp.getWriter().print("</tr>");
			resp.getWriter().print("</tr></table>");
			resp.getWriter().print("<h2>Total lineas: "+LOCcounter+"</h2>");
	  }

}


