function loadAdminMenu() {
    let cont = document.getElementById("container");
    createMenu(cont, "/users", "Ide kattints Jóska!");
    createMenu(cont, "/wallets/2", "Itt vannak a pénztárcák");
    createMenu(cont, "/mywallet.html", "Az én pénztárcám");
}

function loadGuestMenu() {
    let cont = document.getElementById("container");
    createMenu(cont, "/wallets/1", "Ide kattints, Vendég");
    createMenu(cont, "/login.html", "Jelentkezz be, Vendég");
}

function createMenu(place, link, text) {
    let clickMe = document.createElement("a");
    clickMe.setAttribute("href", link);
    clickMe.innerHTML = text;
    place.appendChild(clickMe);
}