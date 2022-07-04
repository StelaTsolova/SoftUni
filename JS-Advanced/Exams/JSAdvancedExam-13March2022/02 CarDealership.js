class CarDealership {
    constructor(name) {
        this.name = name;
        this.availableCars = [];
        this.soldCars = [];
        this.totalIncome = 0;
    }

    addCar(model, horsepower, price, mileage) {
        if (model == '' || horsepower < 0 || price < 0 || mileage < 0) {
            throw new Error('Invalid input!');
        }

        this.availableCars.push({ model, horsepower, price, mileage });

        return `New car added: ${model} - ${horsepower} HP - ${mileage.toFixed(2)} km - ${price.toFixed(2)}$`;
    }

    sellCar(model, desiredMileage) {
        let car = this.availableCars.find(car => car.model == model);
        if (car == undefined) {
            throw new Error(`${model} was not found!`);
        }

        let difference = Math.abs(car.mileage - desiredMileage);
        if (car.mileage > desiredMileage) {
            if (difference <= 40000) {
                car.price -= (car.price * 0.05);
            } else if (difference > 40000) {
                car.price -= (car.price * 0.10);
            }
        }

        let indexCar = this.availableCars.indexOf(car);
        this.availableCars.splice(indexCar, 1);

        delete car.mileage;
        car.soldPrice = car.price;
        delete car.price;

        this.soldCars.push(car);
        this.totalIncome += car.soldPrice;

        return `${model} was sold for ${car.soldPrice.toFixed(2)}$`;
    }

    currentCar() {
        if (this.availableCars.length == 0) {
            return 'There are no available cars';
        } else {
            let output = [];
            output.push('-Available cars:');
            this.availableCars
                .map(c => `---${c.model} - ${c.horsepower} HP - ${c.mileage.toFixed(2)} km - ${c.price.toFixed(2)}$`)
                .forEach(c => output.push(c));

            return output.join('\n');
        }
    }

    salesReport(criteria) {
        if (criteria == 'horsepower') {
            this.soldCars.sort((a, b) => b.horsepower - a.horsepower);
        } else if (criteria == 'model') {
            this.soldCars.sort((a, b) => a.model.localeCompare(b.model));
        } else {
            throw new Error('Invalid criteria!');
        }

        let output = [];
        output.push(`-${this.name} has a total income of ${this.totalIncome.toFixed(2)}$`);
        output.push(`-${this.soldCars.length} cars sold:`);
        this.soldCars
            .map(c => `---${c.model} - ${c.horsepower} HP - ${c.soldPrice.toFixed(2)}$`)
            .forEach(c => output.push(c));

        return output.join('\n');
    }
}