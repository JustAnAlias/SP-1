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
public class Exercise1
{
	public static void main(String[] args)
	{
		Task1 task1 = new Task1();
		Task3 task3 = new Task3();
		Task2 task2 = new Task2();
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		Thread t3 = new Thread(task3);
		t1.start();
		t2.start();
		t3.start();
		try
		{
			t2.join();
		}
		catch(InterruptedException ex)
		{
			ex.printStackTrace();
		}
		task3.stopThread();
	}

	public static class Task1 implements Runnable
	{
		private long sum = 0;
		private boolean keepRunning = true;
		public void stopThread()
		{
			keepRunning = false;
		}
		@Override
		public void run()
		{
			sum = 0;
			for(int i = 0; i < 1000000000; i++)
			{
				sum += i;
			}
			System.out.println("Task1: " + sum);
		}
	}
        
	public static class Task2 implements Runnable
	{
		private int count = 0;
		private boolean keepRunning = true;
		public void stopThread()
		{
			keepRunning = false;
		}
		@Override
		public void run()
		{
			while(keepRunning && (count <= 5))
			{
				System.out.println("Task 2: " + count++);
				try
				{
					Thread.sleep(2000);
				}
				catch(InterruptedException ex)
				{
					ex.printStackTrace();
				}
			}
		}
	}
        
	public static class Task3 implements Runnable
	{
		private int count = 10;
		private boolean keepRunning = true;
		public void stopThread()
		{
			keepRunning = false;
		}
		@Override
		public void run()
		{
			while(keepRunning)
			{
				System.out.println("Task 3: " + count++);
				try
				{
					Thread.sleep(3000);
				}
				catch(InterruptedException ex)
				{
					ex.printStackTrace();
				}
			}
		}
	}
}