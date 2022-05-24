function toHTML(json) {
    let array = JSON.parse(json);
    let output = ['<table>'];
    let objNames = array[0];

    output.push(makeKeyRow(objNames));
    array.forEach(obj => output.push(makeValueRow(obj)));
    output.push('</table>');

    function makeKeyRow(arr) {
        let keys = [];
        Object.keys(arr).forEach(key => {
            keys.push(`<th>${escapeHTML(key)}</th>`);
        });

        return ("<tr>" + keys.join('') + "</tr>");
    }

    function makeValueRow(obj) {
        let rows = [];
        Object.values(obj).forEach(value => {
            rows.push(`<td>${escapeHTML(value)}</td>`);
        });

        return ("<tr>" + rows.join('') + "</tr>");
    }

    function escapeHTML(value) {
        return value
            .toString()
            .replace(/&/g, '&amp;')
            .replace(/</g, '&lt;')
            .replace(/>/g, '&gt;')
            .replace(/"/g, '&quot;')
            .replace(/'/g, '&#39;');
    }

    output.forEach(e => console.log(e));
}