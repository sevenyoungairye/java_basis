<h3>JVM学习笔记</h3>



1. 什么是JVM?

   Java虚拟机, 运行在操作系统，它与硬件没有直接交互。

2. 类装载器是什么？

   - 将.class文件加载到jvm

   - 三种类装载器：
     - Bootstrap启动类加载器，由cpp编写，装在Java的基本类，如String, Object..
     - Extension扩展类装载器，装载扩展过的Java库，如javax包下的文件。
     - AppClassLoader应用程序类加载器，加载当前应用的classpath所有类。

     ​    （用户自定义加载器）

   - 双亲委派机制，先找启动类加载器  -> 扩展类加载器 -> 应用程序类加载器。先找到的先用此模板。

     - ```java
       package top.bitqian;
       
       /**
        * @author echo lovely
        * @date 2021/2/23 11:03
        */
       
       public class GetClassLoader {
       
           public static void main(String[] args) {
       
               // 获取启动类加载器 null
               System.out.println(Object.class.getClassLoader());
       
               System.out.println("\n\n************");
       
               // sun.misc.Launcher$AppClassLoader@18b4aac2 应用程序加载器
               System.out.println(GetClassLoader.class.getClassLoader());
       
               // sun.misc.Launcher$ExtClassLoader@1b6d3586 扩展加载器
               System.out.println(GetClassLoader.class.getClassLoader().getParent());
       
               // 启动类加载器为null
               System.out.println(GetClassLoader.class.getClassLoader().getParent().getParent());
       
           }
       
       }
       
       ```
   
       
   
   - 沙箱安全机制。先找到现用模板。为了Java的源代码不被更改，安全性。
   
     - ```java
       package java.lang;
       
       /**
        * @author echo lovely
        * @date 2021/2/23 11:10
        */
       
       public class String {
       
           public static void main(String[] args) {
       
               /*
                * 错误: 在类 java.lang.String 中找不到 main 方法, 请将 main 方法定义为:
                *    public static void main(String[] args)
                * 否则 JavaFX 应用程序类必须扩展javafx.application.Application
                */
       
               System.out.println("hhh, 沙箱隔离机制, 会先运行 启动类加载器bootstrap, cpp...");
           }
       
       }
       
       ```
   
3. native 本地方法栈 (native method stack)

   - 调用底层操作系统函数，只声明，无实现。
   - 调用c/cpp

4. 程序计数器 (Program Counter Register)

   - 每一个线程都有计数器，而且线程私有，就是一个指针，指向方法区中的字节码。
   - 内存占用很小。它是当前线程所执行的字节码行号指示器。

5. 方法区（Method Area)

   - 它储存了每一个类的结构信息。（类模板）
     - 运行时常量池
     - 字段和方法数据
     - 构造函数和普通方法的字节码内容。
   - 它是规范。不同虚拟机的实现不一样。Java7是永久代，Java8是元空间。
   
6. 栈（stack, watch out!）

   - 栈管运行，堆管存储。
   - 数据结构中的栈（弹夹）和队列（排队）。
   - 储存类型
     - 8种基本数据类型
     - 实例方法
     - 引用类型 Person p
   - Java中的方法 -> 栈帧。
   - 上面的方法必须执行完成后，下面的方法才能执行。压栈操作。
   - java.lang.StackOverFlowError 错误

7. 堆（heap, watch out!）95%都是玩堆。

   - new Person() 就是堆，保存了对象的地址。而类的模式就在方法区。
   - 逻辑上，分为 新生代（伊甸园，from, to）,老年代，元数据（Java7之前叫永久代）
   - todo..
   
8. GC是什么？

   - 分代收集算法
     - 次数上频繁收集Young区
     - 次数上较少收集Old区
     - 基本不动元空间
   - 具体算法实现
     - 引用计数法 (被对象使用的加一，未被使用减一。jvm不采用)
     - 复制算法(将伊甸园区的数据拷贝到from区，from-> 轮询交换。不会产生碎片，快。)
     - 标记清除（mark-swep）,先标记要回收的对象，然后统一回收这些对象。（省内存，有内存碎片留下。）
     - 标记压缩（碎片整理，回收速度缓慢）
   - gc使用场景
     - 内存效率：复制算法>标记清除算法>标记整理算法（简单对比时间复杂度）
     - 内存整齐度：复制算法=标记整理算法>标记清除算法
     - 内存利用率：标记整理=标记清除>复制算法
   - todo...
   
9. JMM(java 内存模型)

   - volatile关键字 (...), 两个线程，一个线程访问另外一个线程的资源。

