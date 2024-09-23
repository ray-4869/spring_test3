package com.sbb.sbb.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private ArticleRepository articleRepository;

    public List<Article> getList() {
        return this.articleRepository.findAll();
    }
}
