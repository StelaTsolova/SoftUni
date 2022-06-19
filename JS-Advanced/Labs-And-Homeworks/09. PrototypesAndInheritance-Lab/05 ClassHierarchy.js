function solve() {
    class Figure {
        constructor() {
            this.units = 'cm';
        }

        get area() {
            return this.area;
        }

        changeUnits(newUnits) {
            this.units = newUnits;
        }

        toString() {
            return `Figures units: ${this.units}`;
        }
    }

    class Circle extends Figure {
        constructor(raduis) {
            super();
            this.raduis = raduis;
        }

        get area() {
            return Math.PI * this.raduis ** 2;
        }

        changeUnits(newUnits) {
            if (this.units == 'm') {
                this.raduis *= 1000;
            } else if (this.units == 'cm') {
                this.raduis *= 10;
            }

            if (newUnits == 'm') {
                this.raduis *= 1000;
            } else if (newUnits == 'cm') {
                this.raduis /= 10;
            }

            super.changeUnits(newUnits);
        }

        toString() {
            return super.toString() + ` Area: ${this.area} - radius: ${this.raduis}`;
        }
    }

    class Rectangle extends Figure {
        constructor(width, height, units) {
            super();

            this.width = width;
            this.height = height;
            this.changeUnits(units);
        }

        get area() {
            return this.width * this.height;
        }

        changeUnits(newUnits) {
            if (this.units == 'm') {
                this.width *= 1000;
                this.height *= 1000;
            } else if (this.units == 'cm') {
                this.width *= 10;
                this.height *= 10;
            }

            if (newUnits == 'm') {
                this.width *= 1000;
                this.height *= 1000;
            } else if (newUnits == 'cm') {
                this.width /= 10;
                this.height /= 10;
            }

            super.changeUnits(newUnits);
        }

        toString() {
            return super.toString() + ` Area: ${this.area} - width: ${this.width}, height: ${this.height}`;
        }
    }

    return {
        Figure,
        Circle,
        Rectangle
    }
}