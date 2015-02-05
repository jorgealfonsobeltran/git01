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
    	FolderIterator listaCarpetas=new FolderIterator();
    	LinkedList<String> pathFiles=new LinkedList<String>();
    	pathFiles.add("C:\\Users\\G40\\Documents\\Universidad\\Proyectos\\psp0.1\\psp01\\programFolder\\src\\main\\java\\edu\\uniandes\\ecos\\App.java");
    	pathFiles.add("C:\\Users\\G40\\Documents\\Universidad\\Proyectos\\psp0.1\\psp01\\programFolder\\src\\test\\java\\edu\\uniandes\\ecos\\AppTest.java");    	
        //assertEquals("Para la los archivos actuales el resultado debe ser  ",pathFiles,  listaCarpetas.Iterator("programFolder"));
    }
}
