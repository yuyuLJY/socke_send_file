package P1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {
	public static void main(String[] args) throws IOException{
		//--------------------接收Client发送过来的文件流信息------------
		ServerSocket serverSocket =new ServerSocket(1000);//选定端口1000
		Socket socket = serverSocket.accept();
		InputStream inStream = socket.getInputStream();
		InputStreamReader streamReader =new InputStreamReader(inStream);
		BufferedReader bufferReader =new BufferedReader(streamReader);
		String message = "";
		while((message = bufferReader.readLine())!=null) {
			System.out.println("Client:"+ message);
		}
		socket.shutdownInput();//关闭输入流
	}
}
