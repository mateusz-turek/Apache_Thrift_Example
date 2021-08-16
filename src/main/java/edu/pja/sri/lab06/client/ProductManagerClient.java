package edu.pja.sri.lab06.client;

import edu.pja.sri.lab06.Product;
import edu.pja.sri.lab06.ProductManager;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.util.List;

public class ProductManagerClient {
	  public static void main(String [] args) {
		    try {
		      TTransport transport;
		     
		      transport = new TSocket("localhost", 9090);
		      transport.open();

		      TProtocol protocol = new  TBinaryProtocol(transport);
		      ProductManager.Client productManagerclient = new ProductManager.Client(protocol);

		      perform(productManagerclient);

		      transport.close();
		    } catch (TException x) {
		      x.printStackTrace();
		    } 
		  }

		  private static void perform(ProductManager.Client productManagerclient) throws TException {
			  List<Product> allProducts = productManagerclient.getProducts();
			  System.out.println(allProducts);
		  }
		}
