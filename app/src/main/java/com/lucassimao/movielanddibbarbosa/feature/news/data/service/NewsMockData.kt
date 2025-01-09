package com.lucassimao.movielanddibbarbosa.feature.news.data.service

import com.lucassimao.movielanddibbarbosa.feature.news.data.model.ArticleModel
import com.lucassimao.movielanddibbarbosa.feature.news.data.model.NewsModel
import javax.inject.Inject

class NewsMockData @Inject constructor() : NewsDataSource {
    override fun getArticles(): NewsModel {
        return NewsModel(
            articleModels = listOf(
                ArticleModel(
                    author = "John Doe",
                    content = "This is the content of the first article.",
                    description = "Durante toda a história do cinema, alguns cães conquistaram tanto ou até mais destaque do que os",
                    publishedAt = "2025-01-07T10:00:00Z",
                    title = "Nem Messi, nem Pimpão: Este é o cachorro com a carreira mais extensa no cinemae",
                    url = "https://example.com/article1",
                    urlToImage = "https://p2.trrsf.com/image/fget/cf/1200/630/middle/images.terra.com/2024/12/25/1195072628-3ee52d78d7e05080b53e9eae14bb176f.jpg"
                ),
                ArticleModel(
                    author = "Jane Smith",
                    content = "Esse é o melhor faroeste da história do cinema, mas ninguém poderia imaginar",
                    description = "O Velho Oeste, ao longo dos últimos anos, pode ter perdido espaço nas salas de cinema para os",
                    publishedAt = "2025-01-06T14:30:00Z",
                    title = "Tech Updates: Second Article",
                    url = "https://example.com/article2",
                    urlToImage = "https://p2.trrsf.com/image/fget/cf/1200/630/middle/images.terra.com/2024/12/23/1021587457-a74f84d46f27653848482e2969e50cd4.jpg"
                )
            ),
            status = "ok",
            totalResults = 2
        )
    }
}