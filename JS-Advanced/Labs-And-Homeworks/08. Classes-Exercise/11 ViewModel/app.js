class Textbox {
    constructor(selector, regex) {
        this._invalidSymbols = regex;

        this._elements = document.querySelectorAll(selector);
        Array.from(this.elements).forEach(e => e.addEventListener('change', () => this.value = e.value));
    }

    get elements() {
        return this._elements;
    }

    get value() {
        return this.elements[0].value;
    }

    set value(newValue) {
        Array.from(this._elements).forEach(e => e.value = newValue);
    }

    isValid() {
        return !this._invalidSymbols.test(this.elements[0].value);
    }
}