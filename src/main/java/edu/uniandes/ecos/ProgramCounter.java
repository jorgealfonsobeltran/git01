package edu.uniandes.ecos;

import java.util.LinkedList;
import java.io.*;

/**
 * 
 * @author Jorge Alfonso Beltrán Sandoval
 * 
 * Clase realizada para encontrar el numero de lineas de 
 * un archivo enviado a la funcion executeCounter
 *
 */
public class ProgramCounter {
	/**
	 * 
	 * ProgramCounter() 
	 * ExecuteCount(String filePath):
	 *
	 */
	public int LOCcounter,methodCounter;
	public LinkedList<String> classNames=new LinkedList<String>();
	public LinkedList<Integer> classLocs=new LinkedList<Integer>();
	public LinkedList<String> methodNames=new LinkedList<String>();
	public LinkedList<Integer> methodLocs=new LinkedList<Integer>();
	/**
	 * ProgramCounter()
	 * 		Inicializa los atributos de la clase
	 */
	public ProgramCounter()
	{
		LOCcounter=0;
		methodCounter=0;
		classNames=new LinkedList<String>();
		classLocs=new LinkedList<Integer>();
		methodNames=new LinkedList<String>();
		methodLocs=new LinkedList<Integer>();
	}
	
	/**
	 * ExecuteCount(String filePath):
	 * 		Cuenta el numero de filas en el archivo indicado
	 * 		en la cadena filePath
	 *
	 */
	public void executeCount(String filePath) throws IOException{
		int lineMethodNumber=0;
		int lineClassNumber=0;
		int openCounter=0;
		int closeCounter=0;
    	File file=new File(filePath);
		FileReader fileReader=new FileReader(file);
		BufferedReader bufferReader=new BufferedReader(fileReader);
		String line;
		String[] methodParts;
		classNames.add(file.getName());
		while((line=bufferReader.readLine()) != null){
			if(!line.trim().isEmpty() && !(line.trim().startsWith("publicclass") || line.trim().startsWith("class")) && !line.trim().startsWith("package") && !line.trim().startsWith("import")  && !(line.trim().startsWith("/")) && !line.trim().startsWith("*") && !line.trim().startsWith("{") && !line.trim().startsWith("}") && !line.trim().startsWith("public") && !line.trim().startsWith("protected")){
				if(openCounter-closeCounter>=2){
					lineMethodNumber++;
				}
				if(openCounter-closeCounter>=1){
					lineClassNumber++;
					LOCcounter++;
				}

			}
			else if((line.contains("public") || line.contains("protected")) && !line.contains(";")){
				line=line.trim().replace("public","").replace("protected", "");
				methodParts=line.split(" ");
				for(String methodName:methodParts){
					if(methodName.contains("(") && !methodNames.contains(methodName.subSequence(0,methodName.indexOf("(")).toString())){
						methodNames.add(methodName.subSequence(0,methodName.indexOf("(")).toString());
						lineMethodNumber=0;
					}
				}
			}
			if(line.trim().startsWith("}")){
				closeCounter++;
				if(openCounter-closeCounter==1){
					methodLocs.add(lineMethodNumber);
					lineMethodNumber=0;
				}
			}
			if(line.trim().contains("{"))openCounter++;
		}
		classLocs.add(lineClassNumber);
		bufferReader.close();
	}
}
