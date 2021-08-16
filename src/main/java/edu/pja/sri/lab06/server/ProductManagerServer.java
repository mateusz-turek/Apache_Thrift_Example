package edu.pja.sri.lab06.server;

import edu.pja.sri.lab06.ProductManager;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;


public class ProductManagerServer {

	  public static ProductManagerHandler handler;

	  public static ProductManager.Processor processor;

	  public static void main(String [] args) {
	    try {
	      handler = new ProductManagerHandler();
	      processor = new ProductManager.Processor(handler);

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

	  public static void simple(ProductManager.Processor processor) {
	    try {
	      TServerTransport serverTransport = new TServerSocket(9090);
	      TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));

	      System.out.println("Starting the simple server...");
	      server.serve();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	 
	}