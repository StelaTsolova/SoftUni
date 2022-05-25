function editElement(element, stringMatch, replacer) {
    let pattern = new RegExp(stringMatch, 'g');
    
    element.textContent = element.textContent.replace(pattern, replacer);
}