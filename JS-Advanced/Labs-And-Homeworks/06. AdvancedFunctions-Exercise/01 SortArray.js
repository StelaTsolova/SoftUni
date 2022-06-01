function solution(numbers, order) {
    if (order == 'asc') {
        numbers.sort((a, b) => a - b);
    } else if (order == 'desc') {
        numbers.sort((a, b) => b - a);
    }

    return numbers
}