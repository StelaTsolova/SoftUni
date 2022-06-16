function solve(info) {
    let resources = new Map();
    let bottles = new Map();

    info.forEach(element => {
        let [name, quantity] = element.split(' => ');
        quantity = Number(quantity);

        if (!resources.has(name)) {
            resources.set(name, 0);
        }

        resources.set(name, resources.get(name) + quantity);

        while (resources.get(name) >= 1000) {
            resources.set(name, resources.get(name) - 1000);

            if (!bottles.has(name)) {
                bottles.set(name, 0);
            }

            bottles.set(name, bottles.get(name) + 1);
        }
    });

    bottles.forEach((v, k) => console.log(`${k} => ${v}`));
}