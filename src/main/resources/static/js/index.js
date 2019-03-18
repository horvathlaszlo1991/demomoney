console.log('Sikerült bejelentkezni');

getUser();

/*
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
*/

function getUser() {
    return fetch("/user")
    .then(function retrieveUserData (response) {
        return response.json();
    })
    .then(function f(userData) {
        loggedUser = userData;
        greetUser(loggedUser);
        return userData;
    })
}

function greetUser(userData) {
    let h1 = document.getElementById("title");
    if (userData.userRole == null) {
        h1.innerHTML = "Üdvözöllek a DemoMoney oldalon, Vendég!"
    } else {
        h1.innerHTML = "Üdvözöllek a DemoMoney oldalon, " + userData.userRole + "!";
    }
    fillContainer(userData);
}

function fillContainer(loggedUser) {
    let cont = document.getElementById("container");
    if (loggedUser.userRole != null) {
        loadAdminMenu();
        console.log("Betöltöm az admin menüt");
    } else {
        loadGuestMenu();
        console.log("Betöltöm a vendég menüt");
    }
}