package cn.hassan.es.pojo;

import io.searchbox.annotations.JestId;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/5/28 22:30
 * Description:
 */
@Data
public class Article {
    @JestId
    private Integer id;
    private String author;
    private String title;
    private String content;
}
