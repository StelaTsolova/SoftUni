function solution() {
    let summary = {};

    Array.from(arguments).forEach(e => {
        let type = typeof e;
        console.log(`${type}: ${e}`);

        if (summary[type] == undefined) {
            summary[type] = 0;
        }
        summary[type]++;
    });

    Object.keys(summary).sort((num1, num2) => summary[num2] - summary[num1])
        .forEach(e => console.log(`${e} = ${summary[e]}`));
}