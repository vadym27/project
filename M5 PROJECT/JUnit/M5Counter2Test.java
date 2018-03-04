package Memory;

import static org.junit.Assert.*;

import org.junit.Test;

public class M5Counter2Test {


	@Test
	public void testResoldre() {
		String res;
		res = M5Counter2.resoldre(15,15);
		assertEquals("-Empat-",res);
		res = M5Counter2.resoldre(16,14);
		assertEquals("Has ganat!",res);
		res = M5Counter2.resoldre(16,13);
		assertEquals("Has ganat!",res);
		res = M5Counter2.resoldre(16,12);
		assertEquals("Has ganat!",res);
		res = M5Counter2.resoldre(16,11);
		assertEquals("Has ganat!",res);
		res = M5Counter2.resoldre(16,10);
		assertEquals("Has ganat!",res);
		res = M5Counter2.resoldre(16,9);
		assertEquals("Has ganat!",res);
		res = M5Counter2.resoldre(16,8);
		assertEquals("Has ganat!",res);
		res = M5Counter2.resoldre(16,7);
		assertEquals("Has ganat!",res);
		res = M5Counter2.resoldre(16,6);
		assertEquals("Has ganat!",res);
		res = M5Counter2.resoldre(16,5);
		assertEquals("Has ganat!",res);
		res = M5Counter2.resoldre(16,4);
		assertEquals("Has ganat!",res);
		res = M5Counter2.resoldre(16,3);
		assertEquals("Has ganat!",res);
		res = M5Counter2.resoldre(16,2);
		assertEquals("Has ganat!",res);
		res = M5Counter2.resoldre(16,1);
		assertEquals("Has ganat!",res);
		res = M5Counter2.resoldre(16,0);
		assertEquals("Has ganat!",res);
		res = M5Counter2.resoldre(0,16);
		assertEquals("Has perdut!",res);
		res = M5Counter2.resoldre(1,16);
		assertEquals("Has perdut!",res);
		res = M5Counter2.resoldre(2,16);
		assertEquals("Has perdut!",res);
		res = M5Counter2.resoldre(3,16);
		assertEquals("Has perdut!",res);
		res = M5Counter2.resoldre(4,16);
		assertEquals("Has perdut!",res);
		res = M5Counter2.resoldre(5,16);
		assertEquals("Has perdut!",res);
		res = M5Counter2.resoldre(6,16);
		assertEquals("Has perdut!",res);
		res = M5Counter2.resoldre(7,16);
		assertEquals("Has perdut!",res);
		res = M5Counter2.resoldre(8,16);
		assertEquals("Has perdut!",res);
		res = M5Counter2.resoldre(9,16);
		assertEquals("Has perdut!",res);
		res = M5Counter2.resoldre(10,16);
		assertEquals("Has perdut!",res);
		res = M5Counter2.resoldre(11,16);
		assertEquals("Has perdut!",res);
		res = M5Counter2.resoldre(12,16);
		assertEquals("Has perdut!",res);
		res = M5Counter2.resoldre(13,16);
		assertEquals("Has perdut!",res);
		res = M5Counter2.resoldre(14,16);
		assertEquals("Has perdut!",res);
		
		
	}
	

}
