console.log('Sikerült bejelentkezni');

fillTable();

function fillTable() {
    let tableBody = document.getElementById('sum-table');
    for (let i = 0; i < 4; i++) {
        let row = document.createElement('tr');
        let widt = document.createElement('td');
        widt.innerHTML = 1;
        let wcash = document.createElement('td');
        wcash.innerHTML = i * 341;
        let wcard = document.createElement('td');
        wcard.innerHTML = i * 623;
        let wtotal = document.createElement('td');
        wtotal.innerHTML = parseInt(wcash.innerHTML) + parseInt(wcard.innerHTML);

        row.appendChild(widt);
        row.appendChild(wcash);
        row.appendChild(wcard);
        row.appendChild(wtotal);
        tableBody.appendChild(row);
    }
}