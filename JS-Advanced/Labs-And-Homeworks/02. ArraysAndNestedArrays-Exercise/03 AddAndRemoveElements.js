function printResult(commands) {
    let numbers = [];

    for (let i = 0; i < commands.length; i++) {

        if (commands[i] === 'add') {
            numbers.push(i + 1);
        } else if (commands[i] === 'remove') {
            numbers.pop();
        }
    }

    if (numbers.length == 0) {
        console.log('Empty');
    } else {
        numbers.forEach(num => console.log(num));
    }
}