function rectangle(width, height, color) {
    let char = color[0].toUpperCase();
    color = char + color.substring(1);

    let object = {
        width,
        height,
        color,
        calcArea: function () {
            return this.width * this.height;
        }
    };

    return object;
}