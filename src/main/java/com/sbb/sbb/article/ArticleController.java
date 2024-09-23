package com.sbb.sbb.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/article")
@RequiredArgsConstructor
@Controller
public class ArticleController {
    private ArticleService articleService;
    @GetMapping("/list")
    public String list (Model model){
        List<Article> list = this.articleService.getList();
        return "article_list";
    }
}
