function solve(arguments) {
    let car = {};

    car['model'] = arguments.model;

    let engine = {};

    if (arguments.power <= 90) {
        engine['power'] = 90;
        engine['volume'] = 1800;
    } else if (arguments.power <= 120) {
        engine['power'] = 120;
        engine['volume'] = 2400;
    } else if (arguments.power <= 200) {
        engine['power'] = 200;
        engine['volume'] = 3500;
    };

    car['engine'] = engine;

    let carriage = {};
    carriage['type'] = arguments.carriage;
    carriage['color'] = arguments.color;

    car['carriage'] = carriage;

    if (arguments.wheelsize % 2 == 0) {
        arguments.wheelsize--;
    };

    let wheels = [0, 0, 0, 0].fill(arguments.wheelsize);

    car['wheels'] = wheels;

    return car;
}