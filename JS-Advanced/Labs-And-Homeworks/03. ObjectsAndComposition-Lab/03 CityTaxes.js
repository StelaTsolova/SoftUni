function cityTaxes(name, population, treasury) {

    let objcet = {
        name: name,
        population: population,
        treasury: treasury,
        taxRate: 10,
        collectTaxes() {
            this.treasury += this.population * this.taxRate;
        },
        applyGrowth(percentage) {
            this.population *= 1 + (percentage / 100);
        },
        applyRecession(percentage) {
            this.treasury *= 1 - (percentage / 100);
        }
    };

    return objcet;
}