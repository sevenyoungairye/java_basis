package top.lel.design.practice.alility_chain;

/**
 * ModuleBHandler
 */
public class ModuleBHandler extends AbstractChainHandler {

    @Override
    protected void calculate(Context context) {
        
        System.out.println("b for calculate.");

        System.out.println(moduleBService.getDataB());
        
    }
    
    
}