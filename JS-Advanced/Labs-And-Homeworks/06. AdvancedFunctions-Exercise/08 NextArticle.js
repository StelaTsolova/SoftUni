function getArticleGenerator(articles) {
    let contentElement = document.querySelector('#content');

    return () => {
        if (articles.length > 0) {
            let articleElement = document.createElement('article');
            articleElement.textContent = articles.shift();

            contentElement.appendChild(articleElement);
        }
    }
}