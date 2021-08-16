package edu.pja.sri.lab06.server;

import edu.pja.sri.lab06.TestManager;
import org.apache.http.util.Args;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

public class TestManagerServer {

    public static TestHandler handler;

    public static TestManager.Processor processor;

    public static void main(String[] args) {
        try{
            handler = new TestHandler();
            processor = new TestManager.Processor(handler);

            Runnable simple = new Runnable() {
                public void run() {
                    simple(processor);
                }
            };
            new Thread(simple).start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void simple(TestManager.Processor processor){
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));

            System.out.println(" starting");
            server.serve();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
