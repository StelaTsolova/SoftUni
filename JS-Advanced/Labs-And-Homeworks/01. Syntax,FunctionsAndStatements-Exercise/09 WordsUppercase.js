function printConvertedText(text) {

    let matches = text.split(/[\W]/)
        .filter(word => word !== '')
        .map(word => word.toUpperCase());

    // let result = text.toUpperCase()
    // .match(/\w+/g)
    // .join(', ');

    console.log(matches.join(', '));
}