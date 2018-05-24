package cn.hassan.rabbitmq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/24 14:58
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	private Integer id;
	private String username;
	private String name;
	private Integer age;
	private BigDecimal balance;
}
