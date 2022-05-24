function solve(info) {
    let output = [];

    let array = info[0].split('|').filter(a => a.length > 0);
    let town = array[0].trim();
    let latitude = array[1].trim();
    let longitude = array[2].trim();

    let baseObject = {};
    baseObject[town] = '';
    baseObject[latitude] = 0;
    baseObject[longitude] = 0;

    for (let i = 1; i < info.length; i++) {
        let [town, latitude, longitude] = info[i].split('|').filter(a => a.length > 0);

        let object = JSON.parse(JSON.stringify(baseObject))
        object.Town = town.trim();
        object.Latitude = Math.round(Number(latitude.trim()) * 100) / 100;
        object.Longitude = Math.round(Number(longitude.trim()) * 100) / 100;

        output.push(object);
    }

    console.log(JSON.stringify(output));
}