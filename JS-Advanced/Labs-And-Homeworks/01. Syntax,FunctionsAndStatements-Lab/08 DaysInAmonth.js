function getNumberDaysOfMonth(month, year) {
    let date = new Date(year, month, 0);

    return date.getDate();
}