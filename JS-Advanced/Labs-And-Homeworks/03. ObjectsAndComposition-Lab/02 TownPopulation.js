function printTownsAndPopulation(input) {

    let information = {};

    for (let row of input) {
        let [town, population] = row.split(' <-> ');
        population = Number(population);

        if (!Object.keys(information).includes(town)) {
            information[town] = population;
        } else {
            information[town] += population;
        }
    };

    for (let name in information) {
        console.log(`${name} : ${information[name]}`);
    };
}