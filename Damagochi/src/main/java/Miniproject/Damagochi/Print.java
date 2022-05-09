package Miniproject.Damagochi;

public class Print extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("   ***     ");
			System.out.println("  *****    ");
			System.out.println("   ***     ");
			System.out.println("    *      ");
			System.out.println("   ***     ");
			System.out.println("  * * *    ");
			System.out.println("   * *     ");
			System.out.println("  *   *    ");
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("   ***     ");
			System.out.println("  *****    ");
			System.out.println("   ***     ");
			System.out.println("    *      ");
			System.out.println(" *******    ");
			System.out.println("    *      ");
			System.out.println("   * *     ");
			System.out.println("  *   *    ");
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("   ***     ");
			System.out.println("  *****    ");
			System.out.println(" * *** *   ");
			System.out.println("  * * *    ");
			System.out.println("   ***     ");
			System.out.println("    *      ");
			System.out.println("   * *     ");
			System.out.println("  *   *    ");
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
