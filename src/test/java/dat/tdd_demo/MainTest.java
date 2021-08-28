/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.tdd_demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jobe
 */
public class MainTest
{
    
    public MainTest()
    {
    }
    
    @BeforeAll
    public static void setUpClass()
    {
    }
    
    @AfterAll
    public static void tearDownClass()
    {
    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testMain()
    {
        
    }
    
    // Requirement 1
    @Test
    public void greetTest()
    {
        String name = "Bob";
        String expected = "Hi, Bob";
        String actual = Main.greet(name);
        assertEquals(expected, actual);
    }
    
    // Requirement 2
    @Test
    public void greetNullTest()
    {
        String name = null;
        String expected = "Hello, my friend";
        String actual = Main.greet(name);
        assertEquals(expected, actual);
    }
    
    // Requirement 3
    @Test
    public void greetUppercaseTest()
    {
        String name = "JERRY";
        String expected = "HELLO JERRY!";
        String actual = Main.greet(name);
        assertEquals(expected, actual);
    }
    
    @Test
    public void greetNotUppercaseTest()
    {
        String name = "JeRRY";
        String expected = "Hi, JeRRY";
        String actual = Main.greet(name);
        assertEquals(expected, actual);
    }
 
    
    // Requirement 4
    @Test
    public void greetTwoNamesTest()
    {
        String[] names = {"Jill", "Jane"};
        String expected = "Hello, Jill and Jane.";
        String actual = Main.greet(names);
        assertEquals(expected, actual);
    }
    
    // Requirement 5
    @Test
    public void greetNamesTest()
    {
        String[] names = {"Amy", "Brian", "Charlotte"};
        String expected = "Hello, Amy, Brian, and Charlotte.";
        String actual = Main.greet(names);
        assertEquals(expected, actual);
    }
     // Requirement 6
    @Test
    public void greetMixedNamesTest()
    {
        String[] names = {"Amy", "BRIAN", "Charlotte"};
        String expected = "Hello, Amy and Charlotte. AND HELLO BRIAN!";
        String actual = Main.greetMixedNames(names);
        assertEquals(expected, actual);
    }
    
     // Requirement 7
    @Test
    public void greetMixedNamesWithCommasTest()
    {
        String[] names = {"Bob", "Charlie, Diane"};
        String expected = "Hello, Bob, Charlie, and Diane.";
        String actual = Main.greetMixedNamesWithCommas(names);
        assertEquals(expected, actual);
    }
    
    // Requirement 8
    
    @Test
    public void greetMixedNamesWithDelimetedCommasTest()
    {
        String[] names = {"Bob", "\"Charlie, Diane\""};
        String expected = "Hello, Bob and Charlie, Diane.";
        String actual = Main.greetMixedNamesWithCommas(names);
        assertEquals(expected, actual);
    }
    
    
    
    
}

