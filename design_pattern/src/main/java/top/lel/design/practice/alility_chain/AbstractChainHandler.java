package top.lel.design.practice.alility_chain;

import top.lel.design.practice.alility_chain.service.ModuleBService;
import top.lel.design.practice.alility_chain.service.ModuleAService;

/**
 * AbstractHandler
 * @author handsome_lee
 * @apiNote AbstractHandler
 * @since 2024/01/28 14:53
 */
public abstract class AbstractChainHandler {

    protected ModuleBService moduleBService = new ModuleBService();

    protected ModuleAService moudleAService = new ModuleAService();

    private AbstractChainHandler nextHandler;

    public void doCalculate(Context context) {

        calculate(context);

        if (getNextHandler() != null) {
            getNextHandler().doCalculate(context);
        }

    }

    /**
     * calculate for data.
     */
    protected abstract void calculate(Context context);


    public void setNextHandler(AbstractChainHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public AbstractChainHandler getNextHandler() {
        return nextHandler;
    }

    
}