const expect = require('chai').expect;
const isSymmetric = require('../05 CheckForSymmetry');

it('Should return false when param is not array', () => {
    expect(isSymmetric(5)).to.be.false;
    expect(isSymmetric('data')).to.be.false;
    expect(isSymmetric({ num: 1 })).to.be.false;
    expect(isSymmetric(true)).to.be.false;
})


describe('Should return true when array is symmetry', () => {
    it('array contains only positive numbers', () => {
        expect(isSymmetric([3, 2, 1, 2, 3])).to.be.true;
    });

    it('array contains only negative numbers', () => {
        expect(isSymmetric([-15, -2, -2, -15])).to.be.true;
    });

    it('array contains positive and negative numbers', () => {
        expect(isSymmetric([12, -5, 4.6, 4.6, -5, 12])).to.be.true;
    });

    it('array is empty', () => {
        expect(isSymmetric([])).to.be.true;
    });

    it('array contains only one element', () => {
        expect(isSymmetric([5])).to.be.true;
    });

    it('array contains only strings', () => {
        expect(isSymmetric(['n', 'cat', 'cat', 'n'])).to.be.true;
    });

    it('array contains numbers and strings', () => {
        expect(isSymmetric(['n', 'cat', 8, 8, 'cat', 'n'])).to.be.true;
    });

    it('array contains only booleans', () => {
        expect(isSymmetric([true, false, false, true])).to.be.true;
    });

    it('array contains randam elements', () => {
        expect(isSymmetric([true, 7, 'm', {x: 4}, ['k', 5], {x: 4}, 'm', 7, true])).to.be.true;
    });
});

describe('Should return false when array is notsymmetry', () => {
    it('array contains only positive numbers', () => {
        expect(isSymmetric([2, 4, 2, 4])).to.be.false;
    });

    it('array contains only negative numbers', () => {
        expect(isSymmetric([-1, -76])).to.be.false;
    });

    it('array contains positive and negative numbers', () => {
        expect(isSymmetric([3, -4, 0, 5.5, 5.5])).to.be.false;
    });

    it('array contains only strings', () => {
        expect(isSymmetric(['n', 'mouse', 'cat', 'n'])).to.be.false;
    });

    it('array contains numbers and strings', () => {
        expect(isSymmetric([7, 'cat', 8, 8, 'cat', 'cat'])).to.be.false;
    });

    it('array contains only booleans', () => {
        expect(isSymmetric([true, false, false, true, true])).to.be.false;
    });

    it('array contains randam elements', () => {
        expect(isSymmetric([true, 7, 'm', {x: 4}, ['k', 5], {x: 8}, 'm', 7, true])).to.be.false;
    });
});