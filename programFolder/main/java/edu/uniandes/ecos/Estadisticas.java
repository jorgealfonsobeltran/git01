package edu.uniandes.ecos;

import java.math.BigDecimal;
import java.util.LinkedList;

public class Estadisticas {
	public double promedio(LinkedList<Double> lista){
		double suma=0,resultado=0;
		for(Double valor : lista){
			suma+=valor;
		}
		resultado=suma/lista.size();
		BigDecimal decimal=new BigDecimal(resultado);
		resultado=Double.parseDouble(decimal.setScale(2,decimal.ROUND_HALF_UP).toString());
		return resultado;
	}
	public double desviacion(LinkedList<Double> lista){
		double sumaDispersion=0,resultado=0;
		double valorPromedio=promedio(lista);
		for(double valor : lista){
			sumaDispersion+=Math.pow(valor-valorPromedio,2);
		}
		resultado=Math.sqrt(sumaDispersion/(lista.size()-1));
		BigDecimal decimal=new BigDecimal(resultado);
		resultado=Double.parseDouble(decimal.setScale(2,decimal.ROUND_HALF_UP).toString());
		return resultado;
	}
}
