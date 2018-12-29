package myjava.mybignumber;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.internal.bytebuddy.asm.Advice.Thrown;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import java.lang.NumberFormatException;

@SuppressWarnings("unused")
class MyBigNumberTest implements IReceiver {

	@Test
	public void testSum_N_1() {
		MyBigNumber mb = new MyBigNumber(this);
		String sum = mb.sum("123", "2");

		assertEquals("125", sum);

		String s = mb.sum("10", "2");

		assertEquals("12", s);
	}

	@Test
	public void testSum_N_2() {
		MyBigNumber mb = new MyBigNumber(this);
		String sum = mb.sum("125", "15");

		assertEquals("140", sum);
	}

	@Test
	public void testSum_N_3() {
		MyBigNumber mb = new MyBigNumber(this);
		String sum = mb.sum("150", "150");

		assertEquals("300", sum);
	}

	@Test
	public void testSum_N_4() {
		MyBigNumber mb = new MyBigNumber(this);
		String sum = mb.sum("1500", "2550");

		assertEquals("4050", sum);
	}

	@Test
    public void testSum_N_5() {
        MyBigNumber mb = new MyBigNumber(this);
        String sum = mb.sum("125", "");
		
        assertEquals("125", sum);
    }
	
    @Test
    public void testSum_N_6() {
        MyBigNumber mb = new MyBigNumber(this);
        String sum = mb.sum("", "125");

        assertEquals("125", sum);
    }
	
	@Test
    public void testSum_N_7() {
        MyBigNumber mb = new MyBigNumber(this);
        String sum = mb.sum(null,"1110");

        assertEquals("1110", sum);
    }

	@Test
    public void testSum_N_8() {
        MyBigNumber mb = new MyBigNumber(this);
        String sum = mb.sum("1110",null);

        assertEquals("1110", sum);
    }
    
	 @Test(expected = NumberFormatException.class)
    public void testSum_N_9() {
        MyBigNumber mb = new MyBigNumber(this);
        mb.sum("-110", "125");
    }
    
	@Test(expected = NumberFormatException.class)
    public void testSum_N_10() {
        MyBigNumber mb = new MyBigNumber(this);
        mb.sum("125","-110");
    }
	
	@Test(expected = NumberFormatException.class)
    public void testSum_N_11() {
        MyBigNumber mb = new MyBigNumber(this);
        mb.sum("A", "125");
    }

    @Test(expected = NumberFormatException.class)
    public void testSum_N_12() {
        MyBigNumber mb = new MyBigNumber(this);
        mb.sum("125", "B");
    }
	@Test
	public void testSum_N_13() {
		MyBigNumber mb = new MyBigNumber(this);
		String sum = mb.sum("505", "505");

		assertEquals("1010", sum);
	}
    
    @Test
	public void testSum_N_14() {
		MyBigNumber mb = new MyBigNumber(this);
		String sum = mb.sum("11111111111", "22222222222");

		assertEquals("33333333333", sum);
	}
    
	@Override
	public void send(String msg) {
		// TODO Auto-generated method stub

	}

}
