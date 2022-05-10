function printNeedMoney(fruit, weightGram, pricePerKg) {
    let weightKg = weightGram / 1000;
    let needMoney = weightKg * pricePerKg;

    console.log(`I need $${needMoney.toFixed(2)} to buy ${weightKg.toFixed(2)} kilograms ${fruit}.`);
}