function printDeckOfCards(cards) {
    const faces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];
    const suits = {
        S: '\u2660',
        H: '\u2665',
        D: '\u2666',
        C: '\u2663'
    };

    let result = [];
    for (let card of cards) {
        let face = card.slice(0, card.length - 1);
        let suit = card.slice(card.length - 1);

        if (!faces.includes(face) || !suits[suit]) {
            console.log(`Invalid card: ${card}`);
            return;
        }

        result.push(face + suits[suit]);
    }

    console.log(result.join(' '));
}