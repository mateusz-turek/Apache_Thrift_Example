package edu.pja.sri.lab06.client;

import edu.pja.sri.lab06.ProductManager;
import edu.pja.sri.lab06.Test;
import edu.pja.sri.lab06.TestManager;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.util.List;
import java.util.Scanner;

public class TestManagerClient {
    public static void main(String[] args) {
        try{
            TTransport transport;
            transport = new TSocket("localhost", 9090);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            TestManager.Client testManagerClient = new TestManager.Client(protocol);

            perform(testManagerClient);
        }catch (TException tException){
            tException.printStackTrace();
        }
    }

    private static void perform(TestManager.Client testManagerClient) throws TException{
        //List<Test> testList = testManagerClient.getTestList();
        Scanner scan = new Scanner(System.in);
        System.out.println("Jak masz na imię?");
        String firstName = scan.nextLine();
        List<Test> tests = testManagerClient.getTestList(firstName);
        System.out.println("call");
        System.out.println(tests);
    }
}
