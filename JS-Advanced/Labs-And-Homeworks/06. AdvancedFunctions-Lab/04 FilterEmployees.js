function solution(data, criteria) {
    let employees = JSON.parse(data);

    let [type, value] = criteria.split('-');
    employees.filter(e => e[type] == value).forEach((e, i) => {
        console.log(`${i}. ${e.first_name} ${e.last_name} - ${e.email}`);
    });
}