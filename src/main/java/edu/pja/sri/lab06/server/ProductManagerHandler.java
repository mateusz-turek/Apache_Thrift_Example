package edu.pja.sri.lab06.server;

import java.util.ArrayList;
import java.util.List;

import edu.pja.sri.lab06.Product;
import edu.pja.sri.lab06.ProductManager;
import org.apache.thrift.TException;

public class ProductManagerHandler implements ProductManager.Iface {


    @Override
    public List<Product> getProducts() throws TException {
        List<Product> myList = new ArrayList();
        Product p1 = new Product(1,"Laptop",1000,4);
        Product p2 = new Product(2,"Computer",2000,2);
        Product p3 = new Product(3,"Mouse",100,6);
        myList.add(p1);
        myList.add(p2);
        myList.add(p3);

        return myList;
    }

}
