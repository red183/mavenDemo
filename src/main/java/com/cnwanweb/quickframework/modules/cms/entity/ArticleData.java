package com.cnwanweb.quickframework.modules.cms.entity;

import com.cnwanweb.quickframework.common.persistence.DataEntity;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class ArticleData extends DataEntity<ArticleData> {
    private static final long serialVersionUID = 1L;
    private String id;
    private String content;
    private String copyfrom;
    private String relation;
    private String allowComment;
    private Article article;

    public ArticleData() {
        this.allowComment = "1";
    }

    public ArticleData(String id) {
        this();
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotBlank
    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Length(
            min = 0,
            max = 255
    )
    public String getCopyfrom() {
        return this.copyfrom;
    }

    public void setCopyfrom(String copyfrom) {
        this.copyfrom = copyfrom;
    }

    @Length(
            min = 0,
            max = 255
    )
    public String getRelation() {
        return this.relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Length(
            min = 1,
            max = 1
    )
    public String getAllowComment() {
        return this.allowComment;
    }

    public void setAllowComment(String allowComment) {
        this.allowComment = allowComment;
    }

    public Article getArticle() {
        return this.article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
