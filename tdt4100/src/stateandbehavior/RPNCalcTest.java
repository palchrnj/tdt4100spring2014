package stateandbehavior;

import no.hal.jex.runtime.JExercise;
import no.hal.jex.standalone.JexStandalone;
import junit.framework.TestCase;

@JExercise(
	description="A RPNCalc must support stack functionality and performing operation."
)
public class RPNCalcTest extends TestCase {

	RPNCalc rpncalc;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		rpncalc = new RPNCalc();
	}

	@JExercise(
		tests="void push(Double)",
		description="The push(Double) method puts the Double argument on the stack."
	)
	public void testPush() {
		rpncalc.push(1);
		assertEquals(1d, rpncalc.peek(0));
		rpncalc.push(2);
		assertEquals(2d, rpncalc.peek(0));
		rpncalc.push(3);
		assertEquals(3d, rpncalc.pop());
	}
	
	@JExercise(
			tests="Double pop()",
			description="The pop() method returns the element on the top of the stack."
			)
	public void testPop() {
		assertEquals(null, rpncalc.pop());
		rpncalc.push(0);
		rpncalc.push(1);
		rpncalc.push(2);
		assertEquals(2d, rpncalc.pop());
		assertEquals(1d, rpncalc.pop());
		rpncalc.push(3);
		assertEquals(3d, rpncalc.pop());
		assertEquals(0d, rpncalc.pop());
	}
	
	@JExercise(
		tests="Double peek(int)",
		description="The peek(int) method returns Double at the position of the argument."
	)
	public void testPeek() {
		rpncalc.push(0);
		rpncalc.push(1);
		rpncalc.push(2);
		assertEquals(2d, rpncalc.peek(0));
		assertEquals(1d, rpncalc.peek(1));
		assertEquals(0d, rpncalc.peek(2));
		assertEquals(null , rpncalc.peek(3));
		assertEquals(null , rpncalc.peek(-1));
	}
	
	@JExercise(
			tests="int getSize()",
			description="The getSize() method retuns the size of the stack."
	)
	public void testGetSize() {
		rpncalc.push(0);
		assertEquals(1, rpncalc.getSize());
		rpncalc.push(1);
		assertEquals(2, rpncalc.getSize());
		rpncalc.push(2);
		assertEquals(3, rpncalc.getSize());
		
	}
	
	@JExercise(
			tests="void performOperation(char)",
			description="The performOperation(char) method performs the operation specified by the char argument and leaves the result on the top of the stack."
	)
	public void testPerformOperation() {
		rpncalc.push(3);
		rpncalc.push(4);
		rpncalc.performOperation('+');
		assertEquals(7d, rpncalc.peek(0));
		
		rpncalc.push(2);
		rpncalc.performOperation('-');
		assertEquals(5d, rpncalc.peek(0));

		rpncalc.push(2);
		rpncalc.performOperation('*');
		assertEquals(10d, rpncalc.peek(0));

		rpncalc.push(4);
		rpncalc.performOperation('/');
		assertEquals(2.5d, rpncalc.peek(0));
		
		rpncalc.push(5);
		rpncalc.performOperation('~');
		assertEquals(2.5d, rpncalc.peek(0));
		assertEquals(5d, rpncalc.peek(1));
	}

	public static void main(String[] args) {
		JexStandalone.main(AccountTest.class);
	}
}