function getSumBetweenParams(n, m) {
    let num1 = Number(n);
    let num2 =  Number(m);
    
    let sum = 0;

    for (let num = num1; num <= num2; num++) {
        sum += num;
    }

   return(sum);
}