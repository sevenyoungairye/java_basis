package top.lel.design.pattern.prototype.deep_clone;


import lombok.Data;

import java.io.*;


/**
 * @author echo lovely
 * @date 2021/4/22 21:34
 * @description
 * <p>
 *     深拷贝实现
 *     1. 实现clone
 *     2. 实现serialize接口, 用流序列化和返序列化
 * </p>
 */

@Data
public class DeepPrototype implements Cloneable, Serializable {

    private static final long serialVersionUID = 7861626038960520623L;

    private String name;

    private DeepCloneableTarget target;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // string, basic type clone..
        super.clone();

        // 1. clone self..
        DeepPrototype deepPrototype = (DeepPrototype) super.clone();

        // 2. deep clone.. clone reference field
        // 缺点: 如果引用类型的变量很多, 需要设置很多..
        deepPrototype.target  = (DeepCloneableTarget) target.clone();

        return deepPrototype;
    }

    public Object cloneBySerial() {

        ByteArrayInputStream byteArrayInputStream = null;
        ObjectOutputStream objectOutputStream = null;

        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            // 序列化 write
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            // 当前对象以流的方式输出
            objectOutputStream.writeObject(this);

            // 反序列化
            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            objectInputStream = new ObjectInputStream(byteArrayInputStream);

            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
