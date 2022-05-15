function getArray(numbers) {

    let max = Number.MIN_SAFE_INTEGER;

    let output = numbers.reduce((acc, val) => {
        if (val >= max) {
            max = val;
            acc.push(max);
        }

        return acc;
    }, [])

    return output;
}