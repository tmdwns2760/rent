package com.springboot.rent.Service;


import com.springboot.rent.data.entity.Articles;
import com.springboot.rent.data.repository.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ArticlesService {

    private final ArticlesRepository articlesRepository;

    @Autowired
    public ArticlesService(ArticlesRepository articlesRepository){
        this.articlesRepository = articlesRepository;
    }

    public Articles findArticlesById(Integer id){
        return articlesRepository.findById(id).orElse(null);
    }
}

