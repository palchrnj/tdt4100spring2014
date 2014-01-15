package stateandbehavior;

import java.util.Random;

public class RandomStringGenerator {
	
	Random random = new Random();
	
	public String getRandomString() {
		int randomInt = random.nextInt(Integer.MAX_VALUE) - Integer.MAX_VALUE / 2;
		return "" + randomInt;
	}
	
	public static void main(String[] args) {
		RandomStringGenerator rsg = new RandomStringGenerator();
		System.out.println(rsg.getRandomString());
	}
}
