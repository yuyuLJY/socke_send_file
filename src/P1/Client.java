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
		//Linux�˵�IP�ţ�192.168.126.130
		//InetAddress address =InetAddress.getLocalHost();
		//String name = address.getHostName();
		//String b = address.getHostAddress();
		//System.out.println(name);
		//-------------------------��Sever�����ļ�����-----------------------
		Socket socket = new Socket("192.168.126.130",1000);
		//ȡ�����������������˷����ֽ���
		OutputStream outStream = socket.getOutputStream();
		InputStream fileStream = new FileInputStream("F:\\1_��������.zip");//���ļ�ת�����������ͳ�ȥ
		byte[] buf = new byte[1024];
		int len = 0;
		//�ֽ���û��д���һֱ�����д
		while((len=fileStream.read(buf))!=-1) {
			outStream.write(buf,0,len);
		}
		socket.shutdownOutput();//�ļ��������
		socket.close();
		fileStream.close();
		//-------------------------����Sever�ļ�-----------------------------
	}
}
