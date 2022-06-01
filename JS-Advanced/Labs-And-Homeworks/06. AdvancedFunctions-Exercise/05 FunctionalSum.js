function add(a) {
    let sum = 0;

    function inner(b) {
        sum += b;

        return inner;
    }

    inner.toString = () => {
        return sum;
    }

    return inner(a);
}