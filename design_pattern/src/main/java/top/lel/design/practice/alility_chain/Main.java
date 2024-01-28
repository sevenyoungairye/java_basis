package top.lel.design.practice.alility_chain;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static AbstractChainHandler abstractHandler; 

    public static void main(String[] args) {
        System.out.println("hello, main.");

        run();
    }

    private static void run() {
        initHandler();

        abstractHandler.doCalculate(new Context());

    }

    private static void initHandler() {

        List<AbstractChainHandler> abstractHandlers = getHandlers();


        for (int i = 0; i < abstractHandlers.size(); i++) {
            if (i == 0) {
                abstractHandler = abstractHandlers.get(0); 
            } else {
                AbstractChainHandler nextHandler = abstractHandlers.get(i);
                abstractHandlers.get(i - 1).setNextHandler(nextHandler);
            }
        }

    }


    private static List<AbstractChainHandler> getHandlers() {

        List<AbstractChainHandler> list = new ArrayList<>();
        AbstractChainHandler aChainHandler = new ModuleAHandler();
        AbstractChainHandler bChainHandler = new ModuleBHandler();

        list.add(aChainHandler);
        list.add(bChainHandler);
        
        return list;
    }

}