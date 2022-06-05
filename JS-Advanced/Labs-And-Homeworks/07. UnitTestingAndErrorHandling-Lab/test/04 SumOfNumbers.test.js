const assert = require('chai').assert;
const expect = require('chai').expect;
const sum = require('../04 SumOfNumbers');

describe('Check returned sum', () => {
    it('when numbers in the array only positive', () => {
        let numbers = [5, 25, 10];
        let expectedSum = 40;

        let actualSum = sum(numbers);

        assert.equal(actualSum, expectedSum);
        // expect(actualSum).to.be.equal(expectedSum);
    });

    it('when numbers in the array only negative', () => {
        let numbers = [-2, -20, -3];
        let expectedSum = -25;

        let actualSum = sum(numbers);

        assert.equal(actualSum, expectedSum);
    });

    it('when numbers in the array positive and negative', () => {
        let numbers = [-5, 20, 0];
        let expectedSum = 15;

        let actualSum = sum(numbers);

        assert.equal(actualSum, expectedSum);
    });

    it('should return 0 when array is empty', () =>{
        assert.equal(sum([]), 0);
    })

    it('should return NaN when the param is string', () => {
        expect(sum('data')).to.be.NaN;
    });

    it('should return n from [n]', () => {
        assert.equal(sum([3]), 3);
    });

    it('should throw when the param is not array', () => {
        assert.throws(function() { sum(10); }, Error);
        assert.throws(function() { sum({num: 10}); }, Error);
        assert.throws(function() { sum(10.2); }, Error);
    });
})
