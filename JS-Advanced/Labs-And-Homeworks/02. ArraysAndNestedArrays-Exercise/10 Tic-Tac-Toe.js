function solve(moves) {

    let dashboard = [[false, false, false],
                     [false, false, false],
                     [false, false, false]];

    let symbol = 'X';

    let haveWinner = false;

    let checkForWinner = function (row, col) {

        //   if(dashboard[row].every(e => e == symbol)){
        //       return true
        //   }
        if (dashboard[row][0] === symbol && dashboard[row][1] === symbol && dashboard[row][2] === symbol) {
            return true;
        }
        if (dashboard[0][col] === symbol && dashboard[1][col] === symbol && dashboard[2][col] === symbol) {
            return true;
        }

        if (dashboard[0][0] === symbol && dashboard[1][1] === symbol && dashboard[2][2] === symbol) {
            return true;
        }
        if (dashboard[2][0] === symbol && dashboard[1][1] === symbol && dashboard[0][2] === symbol) {
            return true;
        }

        return false;
    };

    let haveFreePositions = function () {
        for (let row of dashboard) {
            if (row.includes(false)) {
                return true;
            }
        }

        return false;
    }

    for (let i = 0; i < moves.length; i++) {

        let [row, col] = moves[i].split(' ').map(e => Number(e));

        if (dashboard[row][col] == false) {
            dashboard[row][col] = symbol;

            if (checkForWinner(row, col)) {
                haveWinner = true;
                break;
            }

            symbol = symbol == 'X' ? 'O' : 'X';
        } else {
            console.log("This place is already taken. Please choose another!");
        }

        if (!haveFreePositions()) {
            break;
        }
    }

    if (haveWinner) {
        console.log(`Player ${symbol} wins!`);
    } else {
        console.log('The game ended! Nobody wins :(');
    }

    dashboard.forEach(arr => console.log(arr.join('\t')));
}