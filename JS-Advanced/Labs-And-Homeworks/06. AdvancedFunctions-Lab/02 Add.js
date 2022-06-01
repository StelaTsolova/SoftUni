function solution(number) {
    function add(a) {
        console.log(number);
        return a + number;
    }

    return add.bind(this);
}