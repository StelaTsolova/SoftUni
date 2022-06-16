function solve(info) {
    let company = new Map();

    info.forEach(element => {
        let [brand, model, produced] = element.split(' | ');
        produced = Number(produced);

        if (!company.has(brand)) {
            company.set(brand, new Map());
            company.get(brand).set(model, produced);
        } else if (company.get(brand).has(model)) {
            company.get(brand).set(model, company.get(brand).get(model) + produced);
        } else {
            company.get(brand).set(model, produced);
        }
    });

    company.forEach((v, k) => {
        console.log(k);

        v.forEach((v1, k1) => console.log(`###${k1} -> ${v1}`));
    });
}