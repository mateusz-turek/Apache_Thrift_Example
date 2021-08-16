package edu.pja.sri.lab06.client;

import edu.pja.sri.lab06.BankAccountManager;
import edu.pja.sri.lab06.Customer;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.util.Scanner;

public class BankAccountCreateCustomerClient {
    public static void main(String [] args) {
        try {
            TTransport transport;

            transport = new TSocket("localhost", 9090);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            BankAccountManager.Client bankAccountManagerClient = new BankAccountManager.Client(protocol);

            perform(bankAccountManagerClient);

            transport.close();
        } catch (TException x) {
            x.printStackTrace();
        }
    }

    private static void perform(BankAccountManager.Client bankAccountManagerClient) throws TException {
        Scanner scan = new Scanner(System.in);
        System.out.println("type your name");
        String firstName = scan.nextLine();
        Customer c = bankAccountManagerClient.createCustomer(firstName);
        System.out.println("created customer:" + c.toString());
        System.out.println(c);
    }

}
