package com.sbb.sbb.article;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleForm {
    @NotEmpty(message = "제목입력")
    @Size(max = 200)
    private String title;

    @NotEmpty(message = "내용입력")
    private String content;
}
