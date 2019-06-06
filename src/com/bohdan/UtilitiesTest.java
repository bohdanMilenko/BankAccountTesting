package com.bohdan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class UtilitiesTest {
   private static Utilities testingUtility;

    @BeforeEach
    void setUp() {
        testingUtility = new Utilities();
    }

    @Test
    void getEveryNthNumberTest() {
        char[] transformedInput = {'h','e','l','l','o'};
        char[] requiredOutput = {'e','l'};
        assertArrayEquals(requiredOutput, testingUtility.everyNthChar(transformedInput,2));
    }

    @Test
    void getEveryNthNumberTest2() {
        char[] transformedInput = testingUtility.everyNthChar(new char[] {'h','e','l','l','o'},10);
        char[] requiredOutput = {'e','l'};
        assertArrayEquals(new char[] {'h','e','l','l','o'}, transformedInput);
    }

    @Test
    void removePairsTest(){
        String testStringInitial = "AAABCDDDEEFF";
        String testStringNew = testingUtility.removePairs(testStringInitial);
        assertEquals("ABCDEF", testingUtility.removePairs("AAABCDDDEEFF"));
    }

    @Test
    void removePairsTest2(){
        assertEquals("ABC", testingUtility.removePairs("aAbBCcccC"));
    }
    @Test
    void removePairsTest3(){
        assertEquals("ABC", testingUtility.removePairs("aAbBC c c cC"));
    }
    @Test
    void removePairsTest4(){
        assertNull(testingUtility.removePairs(null));
    }
    @Test
    void removePairsTest5(){
        assertEquals("A", testingUtility.removePairs("A"));
    }

    @ParameterizedTest
    @CsvSource({"ABBCCCCDDDDFFFGGGG, ABCDFG",
            "AB8CCCHHHHTTTT , AB8CHT",
            "111111111122333444999 , 12349",
            "A , A"
    })
    void removePairsTestParameterized(String initialString, String expectedString){
        assertEquals(expectedString, testingUtility.removePairs(initialString));
    }


    @Test
    void converterTest(){
        assertEquals(300,testingUtility.converter(10,5));
    }

    @Test
    void converterTest2(){
        Assertions.assertThrows(ArithmeticException.class,()->{
            testingUtility.converter(10,0);
        });
    }

    @Test
    void oddLengthTest(){
        assertNull(testingUtility.nullIfOddLength("country"));
    }

    @Test
    void oddLengthTest2(){
        assertEquals("junction",testingUtility.nullIfOddLength("junction"));
    }
}
