package edu.pja.sri.lab06.server;

import edu.pja.sri.lab06.BankAccountManager;
import edu.pja.sri.lab06.ProductManager;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

public class BankAccountManagerServer {

    public static BankAccountManagerHandler handler;

    public static BankAccountManager.Processor processor;

    public static void main(String[] args) {
        try {
            handler = new BankAccountManagerHandler();
            processor = new BankAccountManager.Processor(handler);

            Runnable simple = new Runnable() {
                public void run() {
                    simple(processor);
                }
            };

            new Thread(simple).start();
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
    public static void simple(BankAccountManager.Processor processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));

            System.out.println("1 Create Customer by providing your name");
            System.out.println("2 Create BankAccount by providing your name");
            System.out.println("3 Deposit money by providing your name");
            System.out.println("4 Withdraw money by providing your name");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
