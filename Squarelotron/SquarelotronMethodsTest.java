package Squarelotron;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Squarelotron.SquarelotronMethods.Squarelotron;
/**
 *
 * @Author Mengge Zhao, Wei-an Chen
 */
public class SquarelotronMethodsTest {
	//Set up objects' names for the whole junit.
	Squarelotron testing1;
    Squarelotron testing2;
    int[] testing2Array = {1,3,5,7,9,11,12,10,8,6,4,2,13,15,17,19,21,23,24,22,20,18,16,14,25,27,29,31,33,35,36,34,32,30,28,26};

@Before
public void setUp() throws Exception {
	//Set up objects.
    testing1 = new Squarelotron(5);
    testing2 = new Squarelotron(testing2Array);
    

}

@Test
public void testSquarelotron(){
	//check this.size for Squarelotron(int size)
	assertEquals(5,testing1.size);
	////check this.squarelotron for Squarelotron(int size)
	int[][] check1 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
	assertArrayEquals(check1[0],testing1.squarelotron[0]);
	assertArrayEquals(check1[1],testing1.squarelotron[1]);
	assertArrayEquals(check1[2],testing1.squarelotron[2]);
	assertArrayEquals(check1[3],testing1.squarelotron[3]);
	assertArrayEquals(check1[4],testing1.squarelotron[4]);
	//check this.size for Squarelotron(array array)
	assertEquals(6,testing2.size);
	//check this.squarelotron for Squarelotron(array array)
	int[][] check2 = {{1,3,5,7,9,11},{12,10,8,6,4,2},{13,15,17,19,21,23},{24,22,20,18,16,14},{25,27,29,31,33,35},{36,34,32,30,28,26}};
	assertArrayEquals(check2[0],testing2.squarelotron[0]);
	assertArrayEquals(check2[1],testing2.squarelotron[1]);
	assertArrayEquals(check2[2],testing2.squarelotron[2]);
	assertArrayEquals(check2[3],testing2.squarelotron[3]);
	assertArrayEquals(check2[4],testing2.squarelotron[4]);
	assertArrayEquals(check2[5],testing2.squarelotron[5]);
}

@Test
//check method Numbers()
public void testNumbers() {
    int[] checkingArray1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};     
    int[] checkingArray2 = testing2Array;
    assertArrayEquals(checkingArray1, testing1.numbers());
    assertArrayEquals(checkingArray2, testing2.numbers());
}

     /**
	 * The following test methods are all to create the expected answer first.
	 * 
	 * Then, Use assertEquals  assertArrayEquals to check codes.
	 */

@Test
//check method upsideDownFlip(int ring)
public void testUpsideDownFlip() {
	int[] checking1Array = {21,22,23,24,25,16,7,8,9,20,11,12,13,14,15,6,17,18,19,10,1,2,3,4,5};
    Squarelotron checking = new Squarelotron(checking1Array);
    assertArrayEquals(checking.squarelotron[0],testing1.upsideDownFlip(1).squarelotron[0]);
    assertArrayEquals(checking.squarelotron[1],testing1.upsideDownFlip(1).squarelotron[1]);
    assertArrayEquals(checking.squarelotron[2],testing1.upsideDownFlip(1).squarelotron[2]);
    assertArrayEquals(checking.squarelotron[3],testing1.upsideDownFlip(1).squarelotron[3]);
    assertArrayEquals(checking.squarelotron[4],testing1.upsideDownFlip(1).squarelotron[4]);
   
}

@Test
public void testLeftRightFlip() {
    int[] checking1Array = {1,2,3,4,5,6,9,8,7,10,11,14,13,12,15,16,19,18,17,20,21,22,23,24,25};
    Squarelotron checking = new Squarelotron(checking1Array);
    assertArrayEquals(checking.squarelotron[0],testing1.leftRightFlip(2).squarelotron[0]);
    assertArrayEquals(checking.squarelotron[1],testing1.leftRightFlip(2).squarelotron[1]);
    assertArrayEquals(checking.squarelotron[2],testing1.leftRightFlip(2).squarelotron[2]);
    assertArrayEquals(checking.squarelotron[3],testing1.leftRightFlip(2).squarelotron[3]);
    assertArrayEquals(checking.squarelotron[4],testing1.leftRightFlip(2).squarelotron[4]);
   
}

@Test
public void testInverseDiagonalFlip() {
    int[] checking1Array = {25,20,15,10,5,24,7,8,9,4,23,12,13,14,3,22,17,18,19,2,21,16,11,6,1};
    Squarelotron checking = new Squarelotron(checking1Array);
    //assertEquals(checking1Array,testing1.inverseDiagonalFlip(1)); 
    assertArrayEquals(checking.squarelotron[0],testing1.inverseDiagonalFlip(1).squarelotron[0]);
    assertArrayEquals(checking.squarelotron[1],testing1.inverseDiagonalFlip(1).squarelotron[1]);
    assertArrayEquals(checking.squarelotron[2],testing1.inverseDiagonalFlip(1).squarelotron[2]);
    assertArrayEquals(checking.squarelotron[3],testing1.inverseDiagonalFlip(1).squarelotron[3]);
    assertArrayEquals(checking.squarelotron[4],testing1.inverseDiagonalFlip(1).squarelotron[4]);
   
}

@Test
public void testMainDiagonalFlip() {
    int[] checking1Array = {1,6,11,16,21,2,7,8,9,22,3,12,13,14,23,4,17,18,19,24,5,10,15,20,25};
    Squarelotron checking = new Squarelotron(checking1Array);
    //assertEquals(checking1Array,testing1.mainDiagonalFlip(1)); 
    assertArrayEquals(checking.squarelotron[0],testing1.mainDiagonalFlip(1).squarelotron[0]);
    assertArrayEquals(checking.squarelotron[1],testing1.mainDiagonalFlip(1).squarelotron[1]);
    assertArrayEquals(checking.squarelotron[2],testing1.mainDiagonalFlip(1).squarelotron[2]);
    assertArrayEquals(checking.squarelotron[3],testing1.mainDiagonalFlip(1).squarelotron[3]);
    assertArrayEquals(checking.squarelotron[4],testing1.mainDiagonalFlip(1).squarelotron[4]);
}

@Test
public void testSideFlip() {
    int[] checking1Array = {2,1,3,4,5,7,6,8,9,10,12,11,13,14,15,17,16,18,19,20,22,21,23,24,25};
    Squarelotron checking1 = new Squarelotron(checking1Array);
    //assertEquals(checking1Array,testing1.sideFlip("left")); 
    assertArrayEquals(checking1.squarelotron[0],testing1.sideFlip("left").squarelotron[0]);
    assertArrayEquals(checking1.squarelotron[1],testing1.sideFlip("left").squarelotron[1]);
    assertArrayEquals(checking1.squarelotron[2],testing1.sideFlip("left").squarelotron[2]);
    assertArrayEquals(checking1.squarelotron[3],testing1.sideFlip("left").squarelotron[3]);
    assertArrayEquals(checking1.squarelotron[4],testing1.sideFlip("left").squarelotron[4]);
    int[] checking2Array = {1,2,3,5,4,6,7,8,10,9,11,12,13,15,14,16,17,18,20,19,21,22,23,25,24};
    Squarelotron checking2 = new Squarelotron(checking2Array);
    //assertEquals(checking2Array,testing1.sideFlip("right")); 
    assertArrayEquals(checking2.squarelotron[0],testing1.sideFlip("right").squarelotron[0]);
    assertArrayEquals(checking2.squarelotron[1],testing1.sideFlip("right").squarelotron[1]);
    assertArrayEquals(checking2.squarelotron[2],testing1.sideFlip("right").squarelotron[2]);
    assertArrayEquals(checking2.squarelotron[3],testing1.sideFlip("right").squarelotron[3]);
    assertArrayEquals(checking2.squarelotron[4],testing1.sideFlip("right").squarelotron[4]);
    int[] checking3Array = {6,7,8,9,10,1,2,3,4,5,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
    Squarelotron checking3 = new Squarelotron(checking3Array);
    //assertEquals(checking3Array,testing1.sideFlip("top")); 
    assertArrayEquals(checking3.squarelotron[0],testing1.sideFlip("top").squarelotron[0]);
    assertArrayEquals(checking3.squarelotron[1],testing1.sideFlip("top").squarelotron[1]);
    assertArrayEquals(checking3.squarelotron[2],testing1.sideFlip("top").squarelotron[2]);
    assertArrayEquals(checking3.squarelotron[3],testing1.sideFlip("top").squarelotron[3]);
    assertArrayEquals(checking3.squarelotron[4],testing1.sideFlip("top").squarelotron[4]);
    int[] checking4Array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,21,22,23,24,25,16,17,18,19,20};
    Squarelotron checking4 = new Squarelotron(checking4Array);
    //assertEquals(checking4Array,testing1.sideFlip("bottom")); 
    assertArrayEquals(checking4.squarelotron[0],testing1.sideFlip("bottom").squarelotron[0]);
    assertArrayEquals(checking4.squarelotron[1],testing1.sideFlip("bottom").squarelotron[1]);
    assertArrayEquals(checking4.squarelotron[2],testing1.sideFlip("bottom").squarelotron[2]);
    assertArrayEquals(checking4.squarelotron[3],testing1.sideFlip("bottom").squarelotron[3]);
    assertArrayEquals(checking4.squarelotron[4],testing1.sideFlip("bottom").squarelotron[4]);
}

@Test
public void testRotateRightOnce(){
    int[] checking1Array = {21,16,11,6,1,22,17,12,7,2,23,18,13,8,3,24,19,14,9,4,25,20,15,10,5};
    Squarelotron checking1 = new Squarelotron(checking1Array);
    testing1.rorateRightOnce();
    assertEquals(checking1,testing1);
    assertArrayEquals(checking1.squarelotron[0],testing1.squarelotron[0]);
    assertArrayEquals(checking1.squarelotron[1],testing1.squarelotron[1]);
    assertArrayEquals(checking1.squarelotron[2],testing1.squarelotron[2]);
    assertArrayEquals(checking1.squarelotron[3],testing1.squarelotron[3]);
    assertArrayEquals(checking1.squarelotron[4],testing1.squarelotron[4]);
    
}

@Test
public void testRotateRight() {
    int[] checking0Array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
    Squarelotron checking0 = new Squarelotron(checking0Array);
    testing1.rorateRight(0);
    assertEquals(checking0,testing1);
    assertArrayEquals(checking0.squarelotron[0],testing1.squarelotron[0]);
    assertArrayEquals(checking0.squarelotron[1],testing1.squarelotron[1]);
    assertArrayEquals(checking0.squarelotron[2],testing1.squarelotron[2]);
    assertArrayEquals(checking0.squarelotron[3],testing1.squarelotron[3]);
    assertArrayEquals(checking0.squarelotron[4],testing1.squarelotron[4]);
    testing1.rorateRight(4);
    assertEquals(checking0,testing1);
    assertArrayEquals(checking0.squarelotron[0],testing1.squarelotron[0]);
    assertArrayEquals(checking0.squarelotron[1],testing1.squarelotron[1]);
    assertArrayEquals(checking0.squarelotron[2],testing1.squarelotron[2]);
    assertArrayEquals(checking0.squarelotron[3],testing1.squarelotron[3]);
    assertArrayEquals(checking0.squarelotron[4],testing1.squarelotron[4]);
    testing1.rorateRight(-4);
    assertEquals(checking0,testing1);
    assertArrayEquals(checking0.squarelotron[0],testing1.squarelotron[0]);
    assertArrayEquals(checking0.squarelotron[1],testing1.squarelotron[1]);
    assertArrayEquals(checking0.squarelotron[2],testing1.squarelotron[2]);
    assertArrayEquals(checking0.squarelotron[3],testing1.squarelotron[3]);
    assertArrayEquals(checking0.squarelotron[4],testing1.squarelotron[4]);
    
    int[] checking1Array = {21,16,11,6,1,22,17,12,7,2,23,18,13,8,3,24,19,14,9,4,25,20,15,10,5};
    Squarelotron checking1 = new Squarelotron(checking1Array);
    testing1.rorateRight(1);
    assertEquals(checking1,testing1);
    assertArrayEquals(checking1.squarelotron[0],testing1.squarelotron[0]);
    assertArrayEquals(checking1.squarelotron[1],testing1.squarelotron[1]);
    assertArrayEquals(checking1.squarelotron[2],testing1.squarelotron[2]);
    assertArrayEquals(checking1.squarelotron[3],testing1.squarelotron[3]);
    assertArrayEquals(checking1.squarelotron[4],testing1.squarelotron[4]);
    testing1.rorateRight(0-1);
   
    testing1.rorateRight(-3);
    assertEquals(checking1,testing1);
    assertArrayEquals(checking1.squarelotron[0],testing1.squarelotron[0]);
    assertArrayEquals(checking1.squarelotron[1],testing1.squarelotron[1]);
    assertArrayEquals(checking1.squarelotron[2],testing1.squarelotron[2]);
    assertArrayEquals(checking1.squarelotron[3],testing1.squarelotron[3]);
    assertArrayEquals(checking1.squarelotron[4],testing1.squarelotron[4]);
    testing1.rorateRight(0-(-3));
    
    int[] checking2Array = {25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
    Squarelotron checking2 = new Squarelotron(checking2Array);
    testing1.rorateRight(2);
    assertEquals(checking2,testing1);
    assertArrayEquals(checking2.squarelotron[0],testing1.squarelotron[0]);
    assertArrayEquals(checking2.squarelotron[1],testing1.squarelotron[1]);
    assertArrayEquals(checking2.squarelotron[2],testing1.squarelotron[2]);
    assertArrayEquals(checking2.squarelotron[3],testing1.squarelotron[3]);
    assertArrayEquals(checking2.squarelotron[4],testing1.squarelotron[4]);
    testing1.rorateRight(0-2);
    
    testing1.rorateRight(-2);
    assertEquals(checking2,testing1);
    assertArrayEquals(checking2.squarelotron[0],testing1.squarelotron[0]);
    assertArrayEquals(checking2.squarelotron[1],testing1.squarelotron[1]);
    assertArrayEquals(checking2.squarelotron[2],testing1.squarelotron[2]);
    assertArrayEquals(checking2.squarelotron[3],testing1.squarelotron[3]);
    assertArrayEquals(checking2.squarelotron[4],testing1.squarelotron[4]);
    testing1.rorateRight(0-(-2));
    
    int[] checking3Array = {5,10,15,20,25,4,9,14,19,24,3,8,13,18,23,2,7,12,17,22,1,6,11,16,21};
    Squarelotron checking3 = new Squarelotron(checking3Array);
    testing1.rorateRight(3);
    assertEquals(checking3,testing1);
    assertArrayEquals(checking3.squarelotron[0],testing1.squarelotron[0]);
    assertArrayEquals(checking3.squarelotron[1],testing1.squarelotron[1]);
    assertArrayEquals(checking3.squarelotron[2],testing1.squarelotron[2]);
    assertArrayEquals(checking3.squarelotron[3],testing1.squarelotron[3]);
    assertArrayEquals(checking3.squarelotron[4],testing1.squarelotron[4]);
    testing1.rorateRight(0-3);
    
    testing1.rorateRight(-1);
    assertEquals(checking3,testing1);
    assertArrayEquals(checking3.squarelotron[0],testing1.squarelotron[0]);
    assertArrayEquals(checking3.squarelotron[1],testing1.squarelotron[1]);
    assertArrayEquals(checking3.squarelotron[2],testing1.squarelotron[2]);
    assertArrayEquals(checking3.squarelotron[3],testing1.squarelotron[3]);
    assertArrayEquals(checking3.squarelotron[4],testing1.squarelotron[4]);
}

@Test
public void testEquals() {
    
    // always choose s1 to be this squarelotron
    int[] checking0Array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25}; 
    Squarelotron s1 = new Squarelotron(checking0Array);
    
    // check whether size are the same
    Squarelotron s2 = new Squarelotron(5);
    Squarelotron s4 = new Squarelotron(4);
    
    assertEquals(true,s1.equals(s2));
    assertEquals(false,s1.equals(s4));
    
    // check whether elements are the same
    int[] checking1Array = {2,1,3,4,5,7,6,8,9,10,12,11,13,14,15,17,16,18,19,20,22,21,23,24,25};
    Squarelotron s3 = new Squarelotron(checking1Array);
    assertEquals(false,s1.equals(s3));
    assertEquals(true,s1.equals(s2));

}

@Test
//check method toString()
public void testToString(){
    Squarelotron s2 = new Squarelotron(5);
    String expecting ="1\t2\t3\t4\t5\t\n6\t7\t8\t9\t10\t\n11\t12\t13\t14\t15\t\n16\t17\t18\t19\t20\t\n21\t22\t23\t24\t25\t\n";
    assertTrue(s2.toString().equals(expecting));
    assertEquals(expecting,s2.toString());
    
}

}
