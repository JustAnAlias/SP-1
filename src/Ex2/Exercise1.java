/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
/**
 *
 * @author RL^
 */
public class Exercise1
{
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args)
	{
		ImageLoader img1 = new ImageLoader("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png");
		ImageLoader img2 = new ImageLoader("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png");
		ImageLoader img3 = new ImageLoader("https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png");
		Thread t1 = new Thread(img1);
		Thread t2 = new Thread(img2);
		Thread t3 = new Thread(img3);
		t1.start();
		t2.start();
		t3.start();
		while(t1.isAlive() || t2.isAlive() || t3.isAlive())
		// Do nothing
		;
		int totalSum = img1.getByteSum() + img2.getByteSum() + img3.getByteSum();
		System.out.println("Sum is " + totalSum);
	}

        
        
        public static class ImageLoader implements Runnable
	{
		int byteSum;
		String url;
		public int getByteSum()
		{
			return byteSum;
		}
		public ImageLoader(String url)
		{
			this.url = url;
		}
		protected byte[] getBytesFromURL(String url)
		{
			ByteArrayOutputStream bis = new ByteArrayOutputStream();
			try
			{
				InputStream is = new URL(url).openStream();
				byte[] bytebuff = new byte[4096];
				int read;
				while((read = is.read(bytebuff)) > 0)
				{
					bis.write(bytebuff, 0, read);
				}
			}
			catch(IOException ex)
			{
				System.out.println(ex);
			}
			return bis.toByteArray();
		}
		@Override
		public void run()
		{
			byte[] bytes = getBytesFromURL(url);
			for(int i = 0; i < bytes.length; i++) byteSum += bytes[i];
		}
	}
}