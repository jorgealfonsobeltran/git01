package edu.uniandes.ecos;

import java.io.IOException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

/**
 * 
 * @author JorgeAlfonso Beltrán Sandoval
 * Clase Controlador que llama a los modelos 
 * y realiza la impresion de los datos en las vistas
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	FolderIterator listaCarpetas=new FolderIterator();
    	ProgramCounter contadorLineas=new ProgramCounter();
    	PrintConsole impresoraConsola=new PrintConsole();
    	PrintWeb impresoraWeb=new PrintWeb();
    	for(String nombreArchivo: listaCarpetas.Iterator("programFolder")){
    		try {
				contadorLineas.executeCount(nombreArchivo);
			} 
    		catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	impresoraConsola.printAll(contadorLineas.classNames,contadorLineas.methodNames,contadorLineas.classLocs,contadorLineas.methodLocs,contadorLineas.LOCcounter);
	    Server server = new Server(Integer.valueOf(5000));
	    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
	    context.setContextPath("/");
	    server.setHandler(context);
	    impresoraWeb.LOCcounter=contadorLineas.LOCcounter;
	    impresoraWeb.classNames=contadorLineas.classNames;
	    impresoraWeb.methodNames=contadorLineas.methodNames;
	    impresoraWeb.methodLocs=contadorLineas.methodLocs;
	    impresoraWeb.classLocs=contadorLineas.classLocs;
	    context.addServlet(new ServletHolder(impresoraWeb), "/*");
		server.start();
	    server.join();
    }
}
