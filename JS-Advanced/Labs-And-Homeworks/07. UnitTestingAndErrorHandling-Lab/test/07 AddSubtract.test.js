const expect = require('chai').expect;
const createCalculator = require('../07 AddSubtract');

it('Should return value when call element get', () => {
    let module = createCalculator();

    expect(module.get()).to.be.equal(0);
});

it('Should value not change when param is false', () => {
    let module = createCalculator();

    expect(module.get()).to.be.equal(0);

    module.add(false);

    expect(module.get()).to.be.equal(0);
});

describe('Should increases value', () => {
    it('when call element add', () => {
        let module = createCalculator();

        expect(module.get()).to.be.equal(0);

        module.add(5);

        expect(module.get()).to.be.equal(5);
    });

    it('with 1 when call element add and param is true', () => {
        let module = createCalculator();

        expect(module.get()).to.be.equal(0);

        module.add(true);

        expect(module.get()).to.be.equal(1);
    });
})

describe('Should decreases value', () => {
    it('when call element subtract', () => {
        let module = createCalculator();

        expect(module.get()).to.be.equal(0);

        module.subtract(5);

        expect(module.get()).to.be.equal(-5);
    });


    it('with 1 when call element subtract and param is true', () => {
        let module = createCalculator();

        expect(module.get()).to.be.equal(0);

        module.subtract(true);

        expect(module.get()).to.be.equal(-1);
    });
});

describe('Should value to be NaN', () => {
    it('when param is string', () => {
        let module = createCalculator();

        expect(module.get()).to.be.equal(0);

        module.add('string');

        expect(module.get()).to.be.NaN;
    });

    it('when param is NaN', () => {
        let module = createCalculator();

        expect(module.get()).to.be.equal(0);

        module.subtract(NaN);

        expect(module.get()).to.be.NaN
    });
});