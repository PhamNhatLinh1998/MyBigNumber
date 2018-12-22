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
	public void TestSum_N_5() {
		try {
			MyBigNumber mb = new MyBigNumber(this);
			String sum = mb.sum("A", "999");
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
	}

	@Test
	public void TestSum_N_6() {
		try {
			MyBigNumber mb = new MyBigNumber(this);
			String sum = mb.sum("99", "B");
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
	}

	@Test
	public void TestSum_N_7() {
		try {
			MyBigNumber mb = new MyBigNumber(this);
			String sum = mb.sum("99", "-10");
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
	}
    
	@Test
	public void TestSum_N_8() {
		try {
			MyBigNumber mb = new MyBigNumber(this);
			String sum = mb.sum("-99", "10");
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void testSum_N_9() {
		MyBigNumber mb = new MyBigNumber(this);
		String sum = mb.sum("505", "505");

		assertEquals("1010", sum);
	}
	
	@Override
	public void send(String msg) {
		// TODO Auto-generated method stub

	}

}
