function solution(commands) {
    let result = [];

    for (let command of commands) {
        let [type, string] = command.split(' ');
        if (type == 'add') {
            result.push(string);

        } else if (type == 'remove') {
            result = result.filter(e => e !== string);

        } else if (type == 'print') {
            console.log(result.join(','));
        }
    }
}