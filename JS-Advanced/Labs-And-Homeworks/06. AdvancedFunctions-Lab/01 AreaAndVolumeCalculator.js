function solve(area, vol, input) {
    let coordinates = JSON.parse(input);

    // let output = [];
    // for (let points of coordinates) {
    //    output.push({
    //     area: area.call(points),
    //     volume: vol.call(points)
    //    })
    // }

    return coordinates.map(points => {
        return({
            area: area.call(points),
            volume: vol.call(points)
        });
    });
}