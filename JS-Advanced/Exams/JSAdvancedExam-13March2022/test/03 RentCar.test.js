const { expect } = require("chai");
const rentCar = require('../03 RentCar');

describe("Tests", function () {
    describe("searchCar", function () {
        it("should fill findModel when params is valid and have match between model end shop element", function () {
            expect(rentCar.searchCar(['a', 'b'], 'b')).to.be.equal('There is 1 car of model b in the catalog!');
        });
        it("should throw when params is valid and have not match between model end shop elemnt", function () {
            expect(() => rentCar.searchCar(['a', 'b'], 'c')).to.throw('There are no such models in the catalog!');
        });
        it("should throw when shop is not array", function () {
            expect(() => rentCar.searchCar({}, 'c')).to.throw('Invalid input!');
            expect(() => rentCar.searchCar('c', 'c')).to.throw('Invalid input!');
            expect(() => rentCar.searchCar(1, 'c')).to.throw('Invalid input!');
            expect(() => rentCar.searchCar(undefined, 'c')).to.throw('Invalid input!');
            expect(() => rentCar.searchCar(null, 'c')).to.throw('Invalid input!');
        });
        it("should throw when model is not string", function () {
            expect(() => rentCar.searchCar(['a', 'b'], 1)).to.throw('Invalid input!');
            expect(() => rentCar.searchCar(['a', 'b'], [])).to.throw('Invalid input!');
            expect(() => rentCar.searchCar(['a', 'b'], {})).to.throw('Invalid input!');
            expect(() => rentCar.searchCar(['a', 'b'], undefined)).to.throw('Invalid input!');
            expect(() => rentCar.searchCar(['a', 'b'], null)).to.throw('Invalid input!');
        });
    });
    describe("calculatePriceOfCar", function () {
        it("should return info when params is valid and model exist in catalogue", function () {
            expect(rentCar.calculatePriceOfCar('BMW', 2)).to.be.equal('You choose BMW and it will cost $90!');
        });
        it("should throw when params is valid and model not exist in catalogue", function () {
            expect(() => rentCar.calculatePriceOfCar('brand', 2)).to.throw('No such model in the catalog!');
        });
        it("should throw when model is not string", function () {
            expect(() => rentCar.calculatePriceOfCar(2, 2)).to.throw('Invalid input!');
            expect(() => rentCar.calculatePriceOfCar([], 2)).to.throw('Invalid input!');
            expect(() => rentCar.calculatePriceOfCar({}, 2)).to.throw('Invalid input!');
            expect(() => rentCar.calculatePriceOfCar(undefined, 2)).to.throw('Invalid input!');
            expect(() => rentCar.calculatePriceOfCar(null, 2)).to.throw('Invalid input!');
        });
        it("should throw when days is not number", function () {
            expect(() => rentCar.calculatePriceOfCar('brand', '2')).to.throw('Invalid input!');
            expect(() => rentCar.calculatePriceOfCar('brand', [])).to.throw('Invalid input!');
            expect(() => rentCar.calculatePriceOfCar('brand', {})).to.throw('Invalid input!');
            expect(() => rentCar.calculatePriceOfCar('brand', null)).to.throw('Invalid input!');
            expect(() => rentCar.calculatePriceOfCar('brand', undefined)).to.throw('Invalid input!');
        });
    });
    describe("checkBudget", function () {
        it("when params is valid and the budget more than cost", function () {
            expect(rentCar.checkBudget(2, 3, 7)).to.be.equal('You rent a car!');
        });
        it("when params is valid and the budget equal to the cost", function () {
            expect(rentCar.checkBudget(2, 3, 6)).to.be.equal('You rent a car!');
        });
        it("when params is valid and the budget less than the cost", function () {
            expect(rentCar.checkBudget(2, 3, 5)).to.be.equal('You need a bigger budget!');
        });
        it("thorow when costPerDay is not number", function () {
            expect(() => rentCar.checkBudget('2', 3, 6)).to.throw('Invalid input!');
            expect(() => rentCar.checkBudget([], 3, 6)).to.throw('Invalid input!');
            expect(() => rentCar.checkBudget({}, 3, 6)).to.throw('Invalid input!');
            expect(() => rentCar.checkBudget(null, 3, 6)).to.throw('Invalid input!');
            expect(() => rentCar.checkBudget(undefined, 3, 6)).to.throw('Invalid input!');
        });
        it("thorow when days is not number", function () {
            expect(() => rentCar.checkBudget(3, '2', 6)).to.throw('Invalid input!');
            expect(() => rentCar.checkBudget(3, [], 6)).to.throw('Invalid input!');
            expect(() => rentCar.checkBudget(3, {}, 6)).to.throw('Invalid input!');
            expect(() => rentCar.checkBudget(3, null, 6)).to.throw('Invalid input!');
            expect(() => rentCar.checkBudget(3, undefined, 6)).to.throw('Invalid input!');
        });
        it("thorow when budget is not number", function () {
            expect(() => rentCar.checkBudget(3, 6, '2')).to.throw('Invalid input!');
            expect(() => rentCar.checkBudget(3, 6, [])).to.throw('Invalid input!');
            expect(() => rentCar.checkBudget(3, 6, {})).to.throw('Invalid input!');
            expect(() => rentCar.checkBudget(3, 6, null)).to.throw('Invalid input!');
            expect(() => rentCar.checkBudget(3, 6, undefined)).to.throw('Invalid input!');
        });
    });
});