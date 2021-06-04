import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SetClassFunctionalityTest {

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

    //Test 1 (Set, >0, >0) -> base choice test; prateni se dve mnozhestva so elementi i postoi razlika megju dvete mnozhestva
    //                        potrebno e da se vrati rezultantnoto mnozhestvo
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

    //Test 2 (null, >0, >0) -> mozhno e razlikata megju mnozhestvata da bide 0
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

    //Test 3 (NPE, >0, 0) -> isprateniot set2 objekt e null, treba da rezultira so NullPointerException
    @Test
    public void testSet2IsNull(){
        set2=null;
        assertThrows(NullPointerException.class, () -> setClass.setDifference(set1,set2));
    }

    //Test 4 (NPE, 0, >0) -> isprateniot set1 objekt e null, treba da rezultira so NullPointerException
    @Test
    public void testSet1IsNull(){
        set1=null;
        assertThrows(NullPointerException.class, () -> setClass.setDifference(set1,set2));
    }

    //Test 5 (NPE, 0, 0) -> ispratenite set1 i set2 objekti se null, treba da rezultira so NullPointerException
    @Test
    public void testSetsAreNull(){
        set1=set2=null;
        assertThrows(NullPointerException.class, () -> setClass.setDifference(set1,set2));
    }
}