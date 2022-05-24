function solve(info) {
    info.sort((a, b) => a.localeCompare(b));

    let char = '';
    for (let product of info) {
        let [name, price] = product.split(' : ');

        if (name[0] != char) {
            char = name[0];
            console.log(char);
        };

        console.log(`  ${name}: ${price}`)
    };
}