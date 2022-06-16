function solve(tickets, sorting) {
    class Ticket {
        constructor(destination, price, status) {
            this.destination = destination;
            this.price = price;
            this.status = status;
        }
    }

    let result = [];

    tickets.map(e => {
        let [destination, price, status] = e.split('|');
        price = Number(price);

        result.push(new Ticket(destination, price, status));
    });

    return result.sort((a, b) => {
        if (typeof a[sorting] == 'number') {
            return a[sorting] - b[sorting]
        } else {
            return a[sorting].localeCompare(b[sorting]);
        }
    });
}