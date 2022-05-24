function solve(information) {
    let statistic = {};

    for (let info of information) {
        let [town, product, price] = info.split(' | ');
        price = Number(price);

        if (typeof statistic[product] == 'undefined') {
            statistic[product] = [price, town];
        } else if (statistic[product][0] > price) {
            statistic[product][0] = price;
            statistic[product][1] = town;
        }
    }

    for (let [key, value] of Object.entries(statistic)) {
        console.log(`${key} -> ${value[0]} (${value[1]})`)
    }
}