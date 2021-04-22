package top.bitqian.prototype.deep_clone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author echo lovely
 * @date 2021/4/22 21:25
 * @description
 * <p>
 *     深拷贝类
 * </p>
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeepCloneableTarget implements Cloneable, Serializable {

    private static final long serialVersionUID = 2558733895305992661L;

    private String name;

    private String info;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 基本对象, String使用super.clone 实现克隆
        return super.clone();
    }
}
