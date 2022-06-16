const expect = require('chai').expect;
const { describe } = require('mocha');
const StringBuilder = require('../13 StringBuilder');

describe('Tests for constructor', () => {
    it('should throw when param is not undefined and param is not string', () => {
        expect(() => new StringBuilder(8)).to.throw(TypeError);
        expect(() => new StringBuilder(null)).to.throw(TypeError);
        expect(() => new StringBuilder(true)).to.throw(TypeError);
        expect(() => new StringBuilder(NaN)).to.throw(TypeError);
        expect(() => new StringBuilder({})).to.throw(TypeError);
        expect(() => new StringBuilder([])).to.throw(TypeError);
    });

    it('should save empty array when param is undefined', () => {
        let builder = new StringBuilder(undefined);

        expect(builder._stringArray).to.be.an('array').that.is.empty;
    });

    it('should save array from string when param is valid', () => {
        let builder = new StringBuilder('new');

        expect(builder._stringArray).to.be.an('array').to.have.members(['n', 'e', 'w']);
    });
});

describe('Tests for append', () => {
    function getBulder() {
        return new StringBuilder('new');
    }

    it('should throw when param is not string', () => {
        expect(() => getBulder().append(8)).to.throw(TypeError);
        expect(() => getBulder().append(null)).to.throw(TypeError);
        expect(() => getBulder().append(true)).to.throw(TypeError);
        expect(() => getBulder().append(NaN)).to.throw(TypeError);
        expect(() => getBulder().append(undefined)).to.throw(TypeError);
        expect(() => getBulder().append({})).to.throw(TypeError);
        expect(() => getBulder().append([])).to.throw(TypeError);
    });

    it('should add elments in the _stringArray behind', () => {
        let builder = getBulder();
        expect(builder._stringArray).to.have.ordered.members(['n', 'e', 'w']);

        builder.append('On');

        expect(builder._stringArray).to.have.ordered.members(['n', 'e', 'w', 'O', 'n']);
    });
});

describe('Tests for prepend', () => {
    function getBulder() {
        return new StringBuilder('new');
    }

    it('should throw when param is not string', () => {
        expect(() => getBulder().append(8)).to.throw(TypeError);
        expect(() => getBulder().append(null)).to.throw(TypeError);
        expect(() => getBulder().append(true)).to.throw(TypeError);
        expect(() => getBulder().append(NaN)).to.throw(TypeError);
        expect(() => getBulder().append(undefined)).to.throw(TypeError);
        expect(() => getBulder().append([])).to.throw(TypeError);
        expect(() => getBulder().append({})).to.throw(TypeError);
    });

    it('should add elments in the _stringArray front', () => {
        let builder = getBulder();
        expect(builder._stringArray).to.have.ordered.members(['n', 'e', 'w']);

        builder.prepend('On');

        expect(builder._stringArray).to.have.ordered.members(['O', 'n', 'n', 'e', 'w']);
    });
});

describe('Tests for insertAt', () => {
    function getBulder() {
        return new StringBuilder('new');
    }

    it('should throw when param string is not string', () => {
        expect(() => getBulder().append(8)).to.throw(TypeError);
        expect(() => getBulder().append(null)).to.throw(TypeError);
        expect(() => getBulder().append(true)).to.throw(TypeError);
        expect(() => getBulder().append(NaN)).to.throw(TypeError);
        expect(() => getBulder().append(undefined)).to.throw(TypeError);
        expect(() => getBulder().append({})).to.throw(TypeError);
        expect(() => getBulder().append([])).to.throw(TypeError);
    });

    it('should add elments in the _stringArray of a startIndex', () => {
        let builder = getBulder();
        expect(builder._stringArray).to.have.ordered.members(['n', 'e', 'w']);

        builder.insertAt('On', 1);

        expect(builder._stringArray).to.have.ordered.members(['n', 'O', 'n', 'e', 'w']);
    });
});

describe('Tests for remove', () => {
    it('should remove part of the _stringArray', () => {
        let builder = new StringBuilder('builder');
        builder.remove(1, 2);

        expect(builder._stringArray).to.have.ordered.members(['b', 'l', 'd', 'e', 'r']);
    });
});

describe('Tests for toString', () => {
    it('should return the _stringArray like string', () => {
        let builder = new StringBuilder('new');

        expect(builder.toString()).to.be.equal('new');
    });
});