package com.itnkc.search.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/23 15:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "book")
@ToString
public class Book {

    @Id
    private String id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String name;

    @Field(type = FieldType.Date)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    @Field(type = FieldType.Keyword)
    private String author;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String content;
}
