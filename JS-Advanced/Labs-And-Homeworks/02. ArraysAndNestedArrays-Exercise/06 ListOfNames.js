function printSortedNames(names) {
    names.sort((n1, n2) => n1.localeCompare(n2));

    for (let n = 1; n <= names.length; n++) {
        console.log(n + '.' + names[n - 1])
    }
}