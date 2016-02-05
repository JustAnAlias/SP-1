/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;
/**
 *
 * @author RL^
 */
public class Exercise2
{
	public static void main(String[] args)
	{
		Even even = new Even();
		Runnable p1 = new PrintNumbers(even);
		Runnable p2 = new PrintNumbers(even);
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		t1.start();
		t2.start();
	}
	public static class Even
	{
		private int n = 0;
		public int next()
		{
			n++;
			n++;
			return n;
		}
	}
	public static class PrintNumbers implements Runnable
	{
		Even even;
		public PrintNumbers(Even even)
		{
			this.even = even;
		}
		@Override
		public void run()
		{
			for(int i = 0; i < 50; i++)
			{
				System.out.println(even.next());
			}
		}
	}
}