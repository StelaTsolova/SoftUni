const expect = require('chai').expect;
const rgbToHexColor = require('../06 RGBToHex');

describe('Should return undefined when value is invalid', () => {
    it('when value is not Integer', () => {
        expect(rgbToHexColor('h', 5, 7)).to.be.undefined;
        expect(rgbToHexColor(5, [8], 7)).to.be.undefined;
        expect(rgbToHexColor(5, 7, true)).to.be.undefined;
    });

    it('when value less than 0', () => {
        expect(rgbToHexColor(-8, 5, 7)).to.be.undefined;
        expect(rgbToHexColor(5, -8, 7)).to.be.undefined;
        expect(rgbToHexColor(5, 7, -8)).to.be.undefined;
    });

    it('when value more than 255', () => {
        expect(rgbToHexColor(256, 5, 7)).to.be.undefined;
        expect(rgbToHexColor(5, 1269, 7)).to.be.undefined;
        expect(rgbToHexColor(5, 7, 1444444)).to.be.undefined;
    });
});

it('Should hexadecimal color in hexadecimal format when values is valid', () => {
    expect(rgbToHexColor(12, 0, 255)).to.be.equal('#0C00FF');
});