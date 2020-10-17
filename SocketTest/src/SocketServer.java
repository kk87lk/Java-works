import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        while(true){
            Socket socket = serverSocket.accept();
            Runnable runnable = ()->{
                BufferedReader bufferedReader = null;
                try {
                    bufferedReader = new BufferedReader(new
                            InputStreamReader(socket.getInputStream(),"UTF-8"));
                    String str;
                    while((str = bufferedReader.readLine())!=null)
                        System.out.println(str);
                }catch (IOException e){
                    e.printStackTrace();
                }
            };
            executorService.submit(runnable);
        }


    }
}
