function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick)

   function onClick() {
      let inputElement = document.querySelector('#inputs textarea');
      let input = JSON.parse(inputElement.value);

      let restaurant = {};
      for (let element of input) {
         let inputArr = element.split(' - ');
         let restaurantName = inputArr.shift();

         if (!restaurant.hasOwnProperty(restaurantName)) {
            restaurant[restaurantName] = {};
         }

         let workers = inputArr[0].split(', ');
         for (let worker of workers) {
            let [name, salary] = worker.split(' ');

            restaurant[restaurantName][name] = Number(salary);
         }
      }

      let entries = Object.entries(restaurant);
      let bestRestaurantName;
      let bestAvgSalary = 0;
      let bestSalary = 0;
      for (let entity of entries) {

         let salaries = Object.values(entity[1]);
         let totalSalary = 0;
         let maxSalary = 0;
         for (let salary of salaries) {

            totalSalary += salary;

            if (salary > maxSalary) {
               maxSalary = salary;
            }
         }

         let currentAvgSalary = totalSalary / salaries.length;
         if (currentAvgSalary > bestAvgSalary) {
            bestRestaurantName = entity[0];
            bestAvgSalary = currentAvgSalary;
            bestSalary = maxSalary;
         }
      }

      let bestRestaurantElement = document.querySelector('#bestRestaurant p');
      bestRestaurantElement.textContent = `Name: ${bestRestaurantName} Average Salary: ${bestAvgSalary.toFixed(2)} Best Salary: ${bestSalary.toFixed(2)}`;

      let bestWorkersElement = document.querySelector('#workers p');
      let formattedWorkers = Object.entries(restaurant[bestRestaurantName]).sort((a, b) => b[1] - a[1]).map(([k, v]) => `Name: ${k} With Salary: ${v}`)

      bestWorkersElement.textContent = formattedWorkers.join(' ');
   }
}