function solution() {
    const recipes = {
        apple: {
            carbohydrate: 1,
            flavour: 2
        },
        lemonade: {
            carbohydrate: 10,
            flavour: 20
        },
        burger: {
            carbohydrate: 5,
            fat: 7,
            flavour: 3
        },
        eggs: {
            protein: 5,
            fat: 1,
            flavour: 1
        },
        turkey: {
            protein: 10,
            carbohydrate: 10,
            fat: 10,
            flavour: 10
        }
    }

    let microelements = {
        protein: 0,
        carbohydrate: 0,
        fat: 0,
        flavour: 0
    }

    return (param) => {
        let [type, param1, quantity] = param.split(' ');
        quantity = Number(quantity);

        if (type == 'restock') {
            let microelement = param1;
            microelements[microelement] += quantity;
            return 'Success';
        } else if (type == 'prepare') {
            let recipe = param1;
            let needMicroelements = recipes[recipe];

            for (let c = 1; c <= quantity; c++) {
                for (let microelement in needMicroelements) {
                    if (microelements[microelement] < needMicroelements[microelement]) {
                        return `Error: not enough ${microelement} in stock`;
                    }
                }

                for (let microelement in needMicroelements) {
                    microelements[microelement] -= needMicroelements[microelement];
                }
            }
            return 'Success';
            
        } else if (type == 'report') {
            return `protein=${microelements.protein} carbohydrate=${microelements.carbohydrate} fat=${microelements.fat} flavour=${microelements.flavour}`;
        }
    }
}