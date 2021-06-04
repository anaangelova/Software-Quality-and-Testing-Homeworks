import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SetClassInterfaceTest {

    static SetClass<Integer> setClass;
    Set<Integer> set1;
    Set<Integer> set2;
    Set<Integer> result;

    @BeforeAll
    public static void setUp(){
        setClass=new SetClass<>();
    }

    @BeforeEach
    public void init(){
        set1=new HashSet<>();
        set2=new HashSet<>();
        result=new HashSet<>();
    }

    //Test 1 (T,T) -> base choice test; dvete mnozhestva imaat elementi znachi treba da se vrati rezultanten objekt od tip Set
    @Test
    public void testBaseChoice(){
        set1.add(1);
        set1.add(2);
        set1.add(5);
        set2.add(2);
        set2.add(4);
        set2.add(1);
        assertNotNull(setClass.setDifference(set1,set2));
    }

    //Test 2 (T,T) -> base choice test; mozhno e razlikata megju mnozhestvata da bide 0
    @Test
    public void testBaseChoice2(){
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(2);
        set2.add(3);
        set2.add(1);
        assertNull(setClass.setDifference(set1,set2));
    }

    //Test 3 (T, F) -> isprateniot set2 objekt e null, treba da rezultira so NullPointerException
    @Test
    public void testSet2IsNull(){
        set2=null;
        assertThrows(NullPointerException.class, () -> setClass.setDifference(set1,set2));
    }

    //FT - isprateniot set1 objekt e null, treba da rezultira so NullPointerException
    @Test
    public void testSet1IsNull(){
        set1=null;
        assertThrows(NullPointerException.class, () -> setClass.setDifference(set1,set2));
    }
}