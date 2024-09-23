package com.sbb.sbb.article;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/article")
@RequiredArgsConstructor
@Controller
public class ArticleController {
    private final ArticleService articleService;
    @GetMapping("/list")
    public String articleList (Model model, @RequestParam(value = "page", defaultValue = "0") int page){
        Page<Article> paging = this.articleService.getList(page);
        model.addAttribute("paging", paging);
        return "article_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String articleDetail (Model model, @PathVariable("id") Integer id) {
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article_detail";
    }

    @GetMapping("/create")
    public String articleCreate(ArticleForm articleForm) {
        return "article_form";
    }

    @PostMapping("/create")
    public String articleCreate(@Valid ArticleForm articleForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "aritcle_form";
        }
        this.articleService.create(articleForm.getTitle(), articleForm.getContent());
        return "redirect:/article/list";

    }
}
