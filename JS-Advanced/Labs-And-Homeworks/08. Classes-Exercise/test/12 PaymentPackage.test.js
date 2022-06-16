const expect = require('chai').expect;
const PaymentPackage = require('../12 PaymentPackage');

describe('Constructor should', () => {
    it('save data when params is valid', () => {
        let package = new PaymentPackage('pay', 8);

        expect(package.name).to.be.equal('pay');
        expect(package.value).to.be.equal(8);
        expect(package.VAT).to.be.equal(20);
        expect(package.active).to.be.true;
    });

    it('throw when have only one param', () => {
        expect(() => new PaymentPackage('pay')).to.throw(Error);
    });

    it('throw when name is number', () => {
        expect(() => new PaymentPackage(8, 8)).to.throw('Name must be a non-empty string');
    });

    it('throw when missing params', () => {
        expect(() => new PaymentPackage()).to.throw(Error);
    });
});


it('Check get name', () => {
    let package = new PaymentPackage('pay', 8);

    expect(package.name).to.be.equal('pay');
});

describe('Set name should throw Error', () => {
    function getPackage() {
        return new PaymentPackage('pay', 8);
    }

    it('when param is not string', () => {
        expect(() => getPackage().name = 8).to.throw('Name must be a non-empty string');
        expect(() => getPackage().name = NaN).to.throw('Name must be a non-empty string');
        expect(() => getPackage().name = undefined).to.throw('Name must be a non-empty string');
        expect(() => getPackage().name = null).to.throw('Name must be a non-empty string');
        expect(() => getPackage().name = true).to.throw('Name must be a non-empty string');
        expect(() => getPackage().name = []).to.throw('Name must be a non-empty string');
        expect(() => getPackage().name = {}).to.throw('Name must be a non-empty string');
    });

    it('when param is empty string', () => {
        expect(() => getPackage().name = '').to.throw('Name must be a non-empty string');
    });
});

it('Set name should change the name correct', () => {
    let package = new PaymentPackage('pay', 8);
    expect(package.name).to.be.equal('pay');

    package.name = 'new name';

    expect(package.name).to.be.equal('new name');
});


it('Check get value', () => {
    let package = new PaymentPackage('pay', 8);

    expect(package.value).to.be.equal(8);
});

describe('Set value should throw Error', () => {
    function getPackage() {
        return new PaymentPackage('pay', 8);
    }

    it('when param is not number', () => {
        expect(() => getPackage().value = '').to.throw('Value must be a non-negative number');
        expect(() => getPackage().value = undefined).to.throw('Value must be a non-negative number');
        expect(() => getPackage().value = null).to.throw('Value must be a non-negative number');
        expect(() => getPackage().value = true).to.throw('Value must be a non-negative number');
        expect(() => getPackage().value = []).to.throw('Value must be a non-negative number');
        expect(() => getPackage().value = {}).to.throw('Value must be a non-negative number');
    });

    it('when param lass than 0', () => {
        expect(() => getPackage().value = -1).to.throw('Value must be a non-negative number');
    });
});

it('Set value change should the value correct', () => {
    let package = new PaymentPackage('pay', 8);
    expect(package.value).to.be.equal(8);

    package.value = 0;

    expect(package.value).to.be.equal(0);
});


it('Check get VAT', () => {
    let package = new PaymentPackage('pay', 8);

    expect(package.VAT).to.be.equal(20);
});

describe('Set VAT should throw Error', () => {
    function getPackage() {
        return new PaymentPackage('pay', 8);
    }

    it('when param is not number', () => {
        expect(() => getPackage().VAT = '').to.throw('VAT must be a non-negative number');
        expect(() => getPackage().VAT = undefined).to.throw('VAT must be a non-negative number');
        expect(() => getPackage().VAT = null).to.throw('VAT must be a non-negative number');
        expect(() => getPackage().VAT = true).to.throw('VAT must be a non-negative number');
        expect(() => getPackage().VAT = {}).to.throw('VAT must be a non-negative number');
        expect(() => getPackage().VAT = []).to.throw('VAT must be a non-negative number');
    });

    // it('when param is array', () => {
    //     package = new PaymentPackage('paynew', 7);

    //     expect(() => package.VAT = []).to.throw('VAT must be a non-negative number');
    // });

    it('when param lass than 0', () => {
        expect(() => getPackage().VAT = -1).to.throw('VAT must be a non-negative number');
    });
});

it('Set VAT should change the VAT correct', () => {
    let package = new PaymentPackage('pay', 8);
    expect(package.VAT).to.be.equal(20);

    package.VAT = 8;

    expect(package.VAT).to.be.equal(8);
});


it('Check get active', () => {
    let package = new PaymentPackage('pay', 8);

    expect(package.active).to.be.true;
});

it('Set active should throw when param is not boolean', () => {
    function getPackage() {
        return new PaymentPackage('pay', 8);
    }

    expect(() => getPackage().active = '').to.throw('Active status must be a boolean');
    expect(() => getPackage().active = NaN).to.throw('Active status must be a boolean');
    expect(() => getPackage().active = undefined).to.throw('Active status must be a boolean');
    expect(() => getPackage().active = null).to.throw('Active status must be a boolean');
    expect(() => getPackage().active = 8).to.throw('Active status must be a boolean');
    expect(() => getPackage().active = []).to.throw('Active status must be a boolean');
    expect(() => getPackage().active = {}).to.throw('Active status must be a boolean');
});

it('Set active should change the active correct', () => {
    let package = new PaymentPackage('pay', 8);
    expect(package.active).to.be.true;

    package.active = false;

    expect(package.active).to.be.false;
});


describe('Tostring method should return a string as all the properties', () => {
    function getPackage() {
        return new PaymentPackage('pay', 8);
    }

    it('without set property befor this', () => {
        let package = getPackage();

        expect(package.toString()).to.be.equal('Package: pay\n- Value (excl. VAT): 8\n- Value (VAT 20%): 9.6');
    });

    it('with set active befor this', () => {
        let package = getPackage();
        package.active = false;

        expect(package.toString()).to.be.equal('Package: pay (inactive)\n- Value (excl. VAT): 8\n- Value (VAT 20%): 9.6');
    });
});