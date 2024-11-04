package residents;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ResidentTest {
    @Test
    public void testConstructorOk1(){
        Assertions.assertDoesNotThrow(()->new Resident(14,1));
    }

    @Test
    public void testConstructorOk2(){
        Assertions.assertDoesNotThrow(()->new Resident(0,0));
    }

    @Test
    public void testConstructorOk3(){
        Assertions.assertDoesNotThrow(()->new Resident(100,0));
    }

    @Test
    public void testConstructorOk4(){
        Assertions.assertDoesNotThrow(()->new Resident(100,1));
    }

    @Test
    public void testConstructorNok1(){
        Assertions.assertThrows(WrongAgeException.class,()->new Resident(-14,1));
    }

    @Test
    public void testConstructorNok2(){
        Assertions.assertThrows(WrongSexException.class,()->new Resident(14,2));
    }

    @Test
    public void testConstructorNok3(){
        Assertions.assertThrows(WrongAgeException.class,()->new Resident(-14,2));
    }

    @Test
    public void testConstructorNok4(){
        Assertions.assertThrows(WrongAgeException.class,()->new Resident(-1,0));
    }

    @Test
    public void testConstructorNok5(){
        Assertions.assertThrows(WrongAgeException.class,()->new Resident(101,0));
    }

    @Test
    public void testConstructorNok6(){
        Assertions.assertThrows(WrongSexException.class,()->new Resident(10,-1));
    }

    @Test
    public void testConstructorNok7(){
        Assertions.assertThrows(WrongSexException.class,()->new Resident(10,2));
    }

}