
package util;

import domain.DeckClass;
import domain.DeckClassPair;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestForLoopTest {
    Map<DeckClass,Integer> dcIntMap;
    Map<DeckClass, Map<Integer, Integer>> dcIntIntMapMap;
    Map<DeckClassPair, Integer> dcpIntMap;
    Map<DeckClass, Double> dcDoubleMap;
    Map<DeckClassPair, Double> dcpDoubleMap;
    Map<Integer, Integer> intIntMap;
    Map<Integer, Double> intDoubleMap;
    DeckClassPair dcp1;
    DeckClassPair dcp2;
    
    public TestForLoopTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dcIntMap = new HashMap();
        dcIntIntMapMap = new HashMap();
        dcpIntMap = new HashMap();
        dcDoubleMap = new HashMap();
        dcpDoubleMap = new HashMap();
        intIntMap = new HashMap();
        intDoubleMap = new HashMap();
        dcp1 = new DeckClassPair(DeckClass.PALADIN, DeckClass.PRIEST);
        dcp2 = new DeckClassPair(DeckClass.ROGUE, DeckClass.HUNTER);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void zeroesInDcIntMap_returns_true_if_only_zeroes1() {
        Mapper.mapZeroesToDcIntMap(dcIntMap);
        assertTrue(TestForLoop.zeroesInDcIntMap(dcIntMap));
    }
    
    @Test
    public void zeroesInDcIntMap_returns_true_if_only_zeroes2() {
        Mapper.mapZeroesToDcIntMap(dcIntMap);
        assertTrue(TestForLoop.zeroesInDcIntMap(dcIntMap, DeckClass.WARRIOR));
    }
    
    
    @Test
    public void zeroesInDcIntMap_returns_true_if_only_zeroes_besides_exceptions() {
        Mapper.mapZeroesToDcIntMap(dcIntMap);
        dcIntMap.put(DeckClass.MAGE, 1);
        assertTrue(TestForLoop.zeroesInDcIntMap(dcIntMap, DeckClass.MAGE));
    }
    
    @Test
    public void zeroesInDcIntMap_returns_false_if_not_all_are_zeroes1() {
        Mapper.mapZeroesToDcIntMap(dcIntMap);
        dcIntMap.put(DeckClass.MAGE, 3);
        assertFalse(TestForLoop.zeroesInDcIntMap(dcIntMap));
    }
    
    @Test
    public void zeroesInDcIntMap_returns_false_if_not_all_zeroes2() {
        Mapper.mapZeroesToDcIntMap(dcIntMap);
        dcIntMap.put(DeckClass.MAGE, 1);
        assertFalse(TestForLoop.zeroesInDcIntMap(dcIntMap, DeckClass.SHAMAN));
    }
    
    @Test
    public void zeroesInDcpIntMap_returns_true_if_only_zeroes1() {
        Mapper.mapZeroesToDcpIntMap(dcpIntMap);
        assertTrue(TestForLoop.zeroesInDcpIntMap(dcpIntMap));
    }
    
    @Test
    public void zeroesInDcpIntMap_returns_true_if_only_zeroes2() {
        Mapper.mapZeroesToDcpIntMap(dcpIntMap);
        assertTrue(TestForLoop.zeroesInDcpIntMap(dcpIntMap, dcp1));
    }
    
    @Test
    public void zeroesInDcpIntMap_returns_true_if_only_zeroes_besides_exceptions() {
        Mapper.mapZeroesToDcpIntMap(dcpIntMap);
        dcpIntMap.put(dcp1, 4);
        assertTrue(TestForLoop.zeroesInDcpIntMap(dcpIntMap, dcp1));
    }
    
    @Test
    public void zeroesInDcpIntMap_returns_false_if_not_all_zeroes1() {
        Mapper.mapZeroesToDcpIntMap(dcpIntMap);
        dcpIntMap.put(dcp1, 1);
        assertFalse(TestForLoop.zeroesInDcpIntMap(dcpIntMap));
    }
    
    @Test
    public void zeroesInDcpIntMap_returns_false_if_not_all_zeroes2() {
        Mapper.mapZeroesToDcpIntMap(dcpIntMap);
        dcpIntMap.put(dcp1, 6);
        assertFalse(TestForLoop.zeroesInDcpIntMap(dcpIntMap, dcp2));
    }
    
    @Test
    public void zeroesInDcDoubleMap_returns_true_if_only_zeroes1() {
        Mapper.mapZeroesToDcDoubleMap(dcDoubleMap);
        assertTrue(TestForLoop.zeroesInDcDoubleMap(dcDoubleMap));
    }
    
    @Test
    public void zeroesInDcDoubleMap_returns_true_if_only_zeroes2() {
        Mapper.mapZeroesToDcDoubleMap(dcDoubleMap);
        assertTrue(TestForLoop.zeroesInDcDoubleMap(dcDoubleMap, DeckClass.HUNTER));
    }
    
    @Test
    public void zeroesInDcDoubleMap_returns_true_if_only_zeroes_besides_exceptions() {
        Mapper.mapZeroesToDcDoubleMap(dcDoubleMap);
        dcDoubleMap.put(DeckClass.MAGE, 4.0);
        dcDoubleMap.put(DeckClass.SHAMAN, 1.2);
        assertTrue(TestForLoop.zeroesInDcDoubleMap(dcDoubleMap, DeckClass.MAGE, DeckClass.SHAMAN));
    }
    
    @Test
    public void zeroesInDcDoubleMap_returns_false_if_not_only_zeroes1() {
        Mapper.mapZeroesToDcDoubleMap(dcDoubleMap);
        dcDoubleMap.put(DeckClass.MAGE, 1.0);
        assertFalse(TestForLoop.zeroesInDcDoubleMap(dcDoubleMap));
    }
    
    @Test
    public void zeroesInDcDoubleMap_returns_false_if_not_only_zeroes2() {
        Mapper.mapZeroesToDcDoubleMap(dcDoubleMap);
        dcDoubleMap.put(DeckClass.MAGE, 3.3);
        assertFalse(TestForLoop.zeroesInDcDoubleMap(dcDoubleMap, DeckClass.HUNTER));
    }
    
    @Test
    public void zeroesInDcpDoubleMap_returns_true_if_only_zeroes1() {
        Mapper.mapZeroesToDcpDoubleMap(dcpDoubleMap);
        assertTrue(TestForLoop.zeroesInDcpDoubleMap(dcpDoubleMap));
    }
    
    @Test
    public void zeroesInDcpDoubleMap_returns_true_if_only_zeroes2() {
        Mapper.mapZeroesToDcpDoubleMap(dcpDoubleMap);
        assertTrue(TestForLoop.zeroesInDcpDoubleMap(dcpDoubleMap, dcp1, dcp2));
    }
    
    @Test
    public void zeroesInDcpDoubleMap_returns_true_if_only_zeroes_besides_exceptions() {
        Mapper.mapZeroesToDcpDoubleMap(dcpDoubleMap);
        dcpDoubleMap.put(dcp1, 1.111);
        dcpDoubleMap.put(dcp2, 111.111);
        assertTrue(TestForLoop.zeroesInDcpDoubleMap(dcpDoubleMap, dcp1, dcp2));
    }
    
    @Test
    public void zeroesInDcpDoubleMap_returns_false_if_not_only_zeroes1() {
        Mapper.mapZeroesToDcpDoubleMap(dcpDoubleMap);
        dcpDoubleMap.put(dcp1, 2.2);
        assertFalse(TestForLoop.zeroesInDcpDoubleMap(dcpDoubleMap));
    }
    
    @Test
    public void zeroesInDcpDoubleMap_returns_false_if_not_only_zeroes2() {
        Mapper.mapZeroesToDcpDoubleMap(dcpDoubleMap);
        dcpDoubleMap.put(dcp1, 1.111);
        dcpDoubleMap.put(dcp2, 44.44);
        assertFalse(TestForLoop.zeroesInDcpDoubleMap(dcpDoubleMap, dcp1));
    }
    
    @Test
    public void zeroesInInIntMap_returns_true_if_only_zeroes1() {
        Mapper.mapZeroesToIntIntMap(intIntMap);
        assertTrue(TestForLoop.zeroesInIntIntMap(intIntMap));
    }
    
    @Test
    public void zeroesInInIntMap_returns_true_if_only_zeroes2() {
        Mapper.mapZeroesToIntIntMap(intIntMap);
        assertTrue(TestForLoop.zeroesInIntIntMap(intIntMap, 1));
    }
    
    @Test
    public void zeroesInInIntMap_returns_true_if_only_zeroes_besides_exceptions() {
        Mapper.mapZeroesToIntIntMap(intIntMap);
        intIntMap.put(4, 4);
        assertTrue(TestForLoop.zeroesInIntIntMap(intIntMap, 4));
    }
    
    @Test
    public void zeroesInInIntMap_returns_false_if_not_all_zeroes1() {
        Mapper.mapZeroesToIntIntMap(intIntMap);
        intIntMap.put(0, 1);
        assertFalse(TestForLoop.zeroesInIntIntMap(intIntMap));
    }
    
    @Test
    public void zeroesInInIntMap_returns_false_if_not_all_zeroes2() {
        Mapper.mapZeroesToIntIntMap(intIntMap);
        intIntMap.put(12, 3);
        assertFalse(TestForLoop.zeroesInIntIntMap(intIntMap, 0));
    }
    
    @Test
    public void zeroesInIntDoubleMap_returns_true_if_only_zeroes1() {
        Mapper.mapZeroesToIntDoubleMap(intDoubleMap);
        assertTrue(TestForLoop.zeroesInIntDoubleMap(intDoubleMap));
    }
    
    @Test
    public void zeroesInIntDoubleMap_returns_true_if_only_zeroes2() {
        Mapper.mapZeroesToIntDoubleMap(intDoubleMap);
        assertTrue(TestForLoop.zeroesInIntDoubleMap(intDoubleMap, 6));
    }
    
    @Test
    public void zeroesInIntDoubleMap_returns_true_if_only_zeroes_besides_exceptions() {
        Mapper.mapZeroesToIntDoubleMap(intDoubleMap);
        intDoubleMap.put(3, 4.4);
        intDoubleMap.put(4, 3.3);
        assertTrue(TestForLoop.zeroesInIntDoubleMap(intDoubleMap, 3, 4));
    }
    
    @Test
    public void zeroesInIntDoubleMap_returns_false_if_not_only_zeroes1() {
        Mapper.mapZeroesToIntDoubleMap(intDoubleMap);
        intDoubleMap.put(12, 3.1);
        assertFalse(TestForLoop.zeroesInIntDoubleMap(intDoubleMap));
    }
    
    @Test
    public void zeroesInIntDoubleMap_returns_false_if_not_only_zeroes2() {
        Mapper.mapZeroesToIntDoubleMap(intDoubleMap);
        intDoubleMap.put(0, 3.11);
        intDoubleMap.put(3, 111.1111);
        assertFalse(TestForLoop.zeroesInIntDoubleMap(intDoubleMap, 3));
    }
    
    @Test
    public void zeroesInDcIntIntMapMap_returns_true_if_only_zeroes() {
        Mapper.mapZeroesToDcIntIntMapMap(dcIntIntMapMap);
        assertTrue(TestForLoop.zeroesInDcIntIntMapMap(dcIntIntMapMap));
    } 
    
    @Test
    public void zeroesInDcIntIntMapMap_returns_false_if_not_only_zeroes() {
        Mapper.mapZeroesToDcIntIntMapMap(dcIntIntMapMap);
        Mapper.mapZeroesToIntIntMap(intIntMap);
        intIntMap.put(0, 1);
        dcIntIntMapMap.put(DeckClass.MAGE, intIntMap);
        assertFalse(TestForLoop.zeroesInDcIntIntMapMap(dcIntIntMapMap));
    } 
}
