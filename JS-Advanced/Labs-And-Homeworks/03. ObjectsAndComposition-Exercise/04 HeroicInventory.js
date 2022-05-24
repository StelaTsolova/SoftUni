function solve(input) {
    let output = [];

    for (let element of input) {
        let [name, level, items] = element.split(' / ');
        items = items ? items.split(', ') : [];
        level = Number(level);

        output.push({ name, level, items });
    }

    return JSON.stringify(output);
}