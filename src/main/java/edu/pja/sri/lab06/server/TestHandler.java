package edu.pja.sri.lab06.server;

import edu.pja.sri.lab06.Test;
import edu.pja.sri.lab06.TestManager;
import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.List;

public class TestHandler implements TestManager.Iface {

    @Override
    public List<Test> getTestList(String param) throws TException {
        List<Test> testList= new ArrayList<>();
        Test test1 = new Test();
        test1.setS("test2");
        Test test2 = new Test();
        test2.setS("test2");
        testList.add(test1);
        testList.add(test2);
        Test test3 = new Test();
        test3.setS(param);
        testList.add(test3);
        return testList;
    }
}
