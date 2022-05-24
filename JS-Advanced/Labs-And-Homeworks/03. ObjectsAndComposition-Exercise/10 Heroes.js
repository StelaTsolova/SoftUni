function solve() {
    let canFight = (state) => ({
        fight: () => {
            state.stamina -= 1;
            console.log(`${state.name} slashes at the foe!`);
        }
    });

    let canCast = (state) => ({
        cast: (spell) => {
            state.mana -= 1;
            console.log(`${state.name} cast ${spell}`);
        }
    });

    let fighter = function (name) {
        let state = {
            name,
            health: 100,
            stamina: 100
        };

        return Object.assign(state, canFight(state));
    };

    let mage = function (name) {
        let state = {
            name,
            health: 100,
            mana: 100
        };

        return Object.assign(state, canCast(state));
    };

    return { fighter: fighter, mage: mage };
}