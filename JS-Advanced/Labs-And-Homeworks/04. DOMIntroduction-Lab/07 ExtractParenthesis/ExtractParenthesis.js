function extract(content) {
    let pattern = new RegExp(/[(][\w \w]*[)]/, 'g');
    let text = document.getElementById(content);

    let matches = text.textContent.match(pattern);

    return matches.join('; ');
}