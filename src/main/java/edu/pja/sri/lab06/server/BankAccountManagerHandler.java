package edu.pja.sri.lab06.server;

import edu.pja.sri.lab06.BankAccount;
import edu.pja.sri.lab06.BankAccountManager;
import edu.pja.sri.lab06.Customer;
import edu.pja.sri.lab06.Storage;
import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankAccountManagerHandler implements BankAccountManager.Iface {

    private static int idCreator = 0;
    private static final List<Customer> customerList = new ArrayList<>();
    private static final Map<Customer ,BankAccount> customerToBankAccountListMap = new HashMap<>();

    @Override
    public Customer createCustomer(String ownerName) throws TException {
        idCreator++;
        for (Customer c : customerList) {
            if (c.ownerName.equals(ownerName)) {
                throw new TException();
            }
        }
        Customer c = new Customer(idCreator,ownerName);
        customerList.add(c);
        return c;
    }

    @Override
    public BankAccount createBankAccount(String ownerName) throws TException {
        idCreator++;
        Customer customer;
        for (Customer c : customerList){
            if(c.ownerName.equals(ownerName)){
                customer = c;
                if(!customerToBankAccountListMap.containsKey(c)) {
                    BankAccount ba = new BankAccount(idCreator, 0);
                    customerToBankAccountListMap.put(customer, ba);
                    return ba;
                }
            }
        }
        throw new TException();
    }

    @Override
    public double withdrawMoney(String ownerName, double amount) throws TException {
        Customer customer;
        for (Customer c : customerList){
            if(c.ownerName.equals(ownerName)){
                customer = c;
                BankAccount ba = customerToBankAccountListMap.get(customer);
                double state = ba.state;
                if(state < amount){
                    throw new TException();
                }else {
                    state = state - amount;
                    ba.state = state;
                    return ba.state;
                }

            }
        }
        throw new TException();
    }

    @Override
    public double putMoney(String ownerName, double amount) throws TException {
        Customer customer;
        for (Customer c : customerList){
            if(c.ownerName.equals(ownerName)){
                customer = c;
                BankAccount ba = customerToBankAccountListMap.get(customer);
                double state = ba.state;
                state = state + amount;
                ba.state = state;
                return ba.state;
            }
        }
        throw new TException();
    }


}
