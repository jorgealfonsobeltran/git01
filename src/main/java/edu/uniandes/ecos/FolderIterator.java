package edu.uniandes.ecos;

import java.io.*;
import java.util.LinkedList;

/**
 * 
 * @author Jorge Alfonso Beltrán Sandoval
 * Clase realizada para recorrer los archivos encontrados 
 * en la carpeta (folderName)
 *
 */
public class FolderIterator {
	/**
	 * 
	 * folder
	 * pathOfFiles
	 * FolderIterator() 
	 * ExecuteCount(String filePath):
	 * Iterator(String folderName)
	 *
	 */
	
	/**
	 * folder: 	Nombre de la carpeta
	 * 			que contiene los archivos
	 */
	public File folder;
	

	/**
	 * pathOfFiles:	Lista Enlazada con nombre de las
	 *  			ubicaciones de los archivos
	 * 				que contiene la carpeta folder
	 */
	public LinkedList<String> pathOfFiles=new LinkedList<String>();

	/**
	 * foldeIterator:	Constructor
	 */
	public FolderIterator()
	{
		pathOfFiles=new LinkedList<String>();
	}
	

	/**
	 * Iterator(String folderName):	Metodo iterativo que 
	 * 								llena las variables pathOfFiles
	 * 								con los nombres de los archivos
	 * 								
	 */
	public LinkedList<String> Iterator(String folderName)
	{
		folder=new File(folderName);
		File[] listOfFiles=folder.listFiles();
		if(folder.isDirectory()){
			for (File file : listOfFiles) {
				String[] extension=file.getName().split(".");
				if(extension.length>0)System.out.print("-----"+extension[0]);
				if (file.isFile()) {
					if(!pathOfFiles.contains(file.getAbsolutePath())){
						pathOfFiles.add(file.getAbsolutePath());
					}
				}
				else if(file.isDirectory()){
					Iterator(file.getAbsolutePath());
				}
			}
		}
		return pathOfFiles;
	}
}
