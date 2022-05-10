function print(input, op1, op2, op3, op4, op5) {
    let number = Number(input);
    let operations = [op1, op2, op3, op4, op5];

    operations.forEach(operation => {
        switch (operation) {
            case 'chop':
                number /= 2;
                break;
            case 'dice':
                number = Math.sqrt(number);
                break;
            case 'spice':
                number += 1;
                break;
            case 'bake':
                number *= 3;
                break;
            case 'fillet':
                number = (number * 0.80).toFixed(1);
                break;
        }

        console.log(number);
    });
}