class Company {
    constructor() {
        this.departments = {};
    }

    addEmployee(name, salary, position, department) {
        if (name == '' || name == undefined || name == null
            || salary == '' || salary == undefined || salary == null
            || position == '' || position == undefined || position == null
            || department == '' || department == undefined || department == null
            || salary < 0) {
            throw new Error('Invalid input!');
        }

        if (!(department in this.departments)) {
            this.departments[department] = [];
        }

        this.departments[department].push([name, salary, position]);

        return `New employee is hired. Name: ${name}. Position: ${position}`;
    }

    bestDepartment() {
        Object.values(this.departments).sort((d1, d2) => {
            let d1SumSalary = d1.reduce((e1, e2) => e1[1] + e2[1], 0);
            let d2SumSalary = d2.reduce((e1, e2) => e1[1] + e2[1], 0);

            let d1AvgSum = d1SumSalary / d1.size;
            let d2AvgSum = d2SumSalary / d2.size;

            return d2AvgSum - d1AvgSum;
        })

        let theBestDepartmentValues = Object.values(this.departments)[0];

        let sumSalary = 0;
        for (let employee of theBestDepartmentValues) {
            sumSalary += employee[1];
        }

        let avgSum = sumSalary / theBestDepartmentValues.length;

        theBestDepartmentValues.sort((n1, n2) => n1[0].localeCompare(n2[0])).sort((k1, k2) => k2[1] - k1[1]);

        let result = `Best Department is: ${Object.keys(this.departments)[0]}\nAverage salary: ${avgSum.toFixed(2)}`;

        for (let employee of theBestDepartmentValues) {
            result += `\n${employee[0]} ${employee[1]} ${employee[2]}`
        }

        return result
    }
}