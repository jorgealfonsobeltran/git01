package edu.uniandes.ecos;
import java.util.*;
import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
	    	LinkedList<Double> listaNumeros=new LinkedList<Double>();
	    	File archivo=new File("arreglo.txt");
			FileReader lectorArchivo=new FileReader(archivo);
			BufferedReader bufferLector=new BufferedReader(lectorArchivo);
			String linea;
			Estadisticas estadisticas=new Estadisticas();
			int numeroLinea=0;
			double resultado=0;
			Scanner teclado=new Scanner(System.in);
			
	
	    	System.out.println("Opciones:\n1. Calcular promedio. \n2. Calcular Desviación Estandar. \nInserte en el archivo arreglo.txt los valores del arreglo.");
			while((linea=bufferLector.readLine ()) != null){
				numeroLinea++;
				try{
					listaNumeros.add(Double.parseDouble(linea));
				}
				catch(Exception e){
					System.out.println("La linea "+numeroLinea);
				}
			}
			bufferLector.close();
			
			
			System.out.println("\nSeleccione una opción");
			String tecla=teclado.nextLine();
			int numeroTecla=Integer.parseInt(tecla);
			switch(numeroTecla){
			case 1:
				resultado=estadisticas.promedio(listaNumeros);
				break;
			case 2:
				resultado=estadisticas.desviacion(listaNumeros);
				break;
			}
			teclado.close();
	    	System.out.println(resultado);
    }
}
