package cn.hassan.rabbitmq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/5/23 22:36
 * Description: TODO rabbitmq 在序列化消息实体的时候需要无参的构造方法和有参的构造方法
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

    private String bookName;
    private String author;
}
