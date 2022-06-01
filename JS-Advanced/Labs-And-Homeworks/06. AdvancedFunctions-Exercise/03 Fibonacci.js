function getFibonator() {
    let a = 0;
    let b = 1;

    return () =>{
        let sum = a + b;
        a = b;
        b = sum;

        return a;
    } 
}