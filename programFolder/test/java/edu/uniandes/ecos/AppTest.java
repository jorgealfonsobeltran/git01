package edu.uniandes.ecos;

import java.util.LinkedList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	Estadisticas estadisticas=new Estadisticas();
    	LinkedList<Double> lista1=new LinkedList<Double>(),lista2=new LinkedList<Double>();
    	lista1.add(160.0);
    	lista1.add(591.0);
    	lista1.add(114.0);
    	lista1.add(229.0);
    	lista1.add(230.0);
    	lista1.add(270.0);
    	lista1.add(128.0);
    	lista1.add(1657.0);
    	lista1.add(624.0);
    	lista1.add(1503.0);
    	lista2.add(15.0);
    	lista2.add(69.9);
    	lista2.add(6.5);
    	lista2.add(22.4);
    	lista2.add(28.4);
    	lista2.add(65.9);
    	lista2.add(19.4);
    	lista2.add(198.7);
    	lista2.add(38.8);
    	lista2.add(138.2);
        assertEquals("Para la lista 1 el promedio debe ser ",	550.6,  estadisticas.promedio(lista1));
        assertEquals("Para la lista 2 el promedio debe ser ",	60.32,  estadisticas.promedio(lista2));
        assertEquals("Para la lista 1 la desviacion debe ser ",	572.03,  estadisticas.desviacion(lista1));
        assertEquals("Para la lista 2 la desviacion debe ser ",	62.26,  estadisticas.desviacion(lista2));
    }
}
