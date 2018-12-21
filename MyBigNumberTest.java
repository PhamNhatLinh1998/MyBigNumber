import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.internal.bytebuddy.asm.Advice.Thrown;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class MyBigNumberTest implements IReceiver{

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
		
		assertThrows(NumberFormatException.class, new Executable() {
			
			@Override
			public void execute() throws Throwable {
				// TODO Auto-generated method stub
				MyBigNumber mb = new MyBigNumber(MyBigNumberTest.this);
				String sum = mb.sum("2cd", "125");
				
			}
		});
		
	}
	
	@Override
	public void send(String msg) {
		// TODO Auto-generated method stub
		
		
	
	}

}