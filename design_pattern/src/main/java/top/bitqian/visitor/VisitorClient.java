package top.bitqian.visitor;

import top.bitqian.visitor.element.Man;
import top.bitqian.visitor.element.Woman;

/**
 * @author echo lovely
 * @date 2021/5/12 20:15
 * @description ..
 */

public class VisitorClient {

    public static void main(String[] args) {

        ObjectStructure os = new ObjectStructure();
        Man man = new Man();
        man.setName("jack");
        os.attach(man);
        Woman woman = new Woman();
        woman.setName("rose");
        os.attach(woman);

        os.display(new Success());

    }

}
