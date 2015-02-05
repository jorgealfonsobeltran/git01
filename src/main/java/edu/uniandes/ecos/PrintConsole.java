package edu.uniandes.ecos;

import java.util.LinkedList;

/**
 * 
 * @author Jorge Alfonso Beltrán Sandoval
 * Clase realizada para imprimir datos por consola
 *
 */
public class PrintConsole {

	/**
	 * 
	 * printAll(LinkedList<String> valuesClassName,LinkedList<String> valuesMethodName,LinkedList<Integer> valuesClassLocs,LinkedList<Integer> valuesMethodLocs,int LOCcounter)
	 * printListString(LinkedList<String> values)
	 * printListInteger(LinkedList<Integer> values)
	 * printLineNumber
	 * 
	 */
	

	/**
	 * 
	 * printAll(LinkedList<String> valuesClassName,LinkedList<String> valuesMethodName,LinkedList<Integer> valuesClassLocs,LinkedList<Integer> valuesMethodLocs,int LOCcounter)
	 *		Imprime todos los valores recibidos como parametros 
	 *		invocando a los demas metodos
	 *
	 * */
	public void printAll(LinkedList<String> valuesClassName,LinkedList<String> valuesMethodName,LinkedList<Integer> valuesClassLocs,LinkedList<Integer> valuesMethodLocs,int LOCcounter){
    	printListString(valuesClassName);
    	printListInteger(valuesClassLocs);
    	printListString(valuesMethodName);
    	printListInteger(valuesMethodLocs);
    	printLineNumber(LOCcounter);
	}
	

	/**
	 * 
	 * printListString(LinkedList<String> values){
	 *		Imprime todos los valores recibidos en la lista
	 *		la listaEnlazada debe contener datos tip String
	 *
	 * */
	public void printListString(LinkedList<String> values){
		System.out.print("Nombre (Metodos,Clases) \t");
		for(String value: values){
			System.out.print(value+"\t");
		}
		System.out.print("\n");
	}
	

	/**
	 * 
	 * printListInteger(LinkedList<String> values){
	 *		Imprime todos los valores recibidos en la lista
	 *		la listaEnlazada debe contener datos tipo Integer
	 *
	 * */
	public void printListInteger(LinkedList<Integer> values){
		System.out.print("Numero de Lineas \t");
		for(Integer value: values){
			System.out.print(value+"\t");
		}
		System.out.print("\n");
	}


	/**
	 * 
	 * printLineNumber(LinkedList<String> values){
	 *		Imprime el valor recibido
	 *		el valor debe ser de tipo Entero(Int)
	 *
	 * */
	public void printLineNumber(int values){
		System.out.print("Numero de Lineas totales \t");
		System.out.print(values+"\n");
	}
}
