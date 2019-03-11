package P1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws IOException{
		//Linux端的IP号：192.168.126.130
		//InetAddress address =InetAddress.getLocalHost();
		//String name = address.getHostName();
		//String b = address.getHostAddress();
		//System.out.println(name);
		//-------------------------向Sever发送文件过程-----------------------
		Socket socket = new Socket("192.168.126.130",1000);
		//取得输出流，向服务器端发送字节流
		OutputStream outStream = socket.getOutputStream();
		InputStream fileStream = new FileInputStream("F:\\1_宝洁数据.zip");//把文件转化成流，发送出去
		byte[] buf = new byte[1024];
		int len = 0;
		//字节流没有写完就一直向外边写
		while((len=fileStream.read(buf))!=-1) {
			outStream.write(buf,0,len);
		}
		socket.shutdownOutput();//文件传输完毕
		socket.close();
		fileStream.close();
		//-------------------------接收Sever文件-----------------------------
	}
}
