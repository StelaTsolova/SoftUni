function getPreviousDate(year, month, day) {
    let date = new Date(`${year}-${month}-${day}`);

    date.setDate(date.getDate() - 1)

    return (`${date.getFullYear()}-${date.getMonth() + 1}-${date.getDate()}`);
}