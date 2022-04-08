package browserLaunch;

import java.util.Random;

public class RandomClass {

	public static void main(String[] args) {
		Random r=new Random();
		System.out.println(r.nextInt(100));
		System.out.println(r.nextInt(1000));
	}

}
