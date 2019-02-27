function loadAdminMenu() {
    let cont = document.getElementById("container");
    createMenu(cont, "/users", "Ide kattints Jóska!");
    createMenu(cont, "/wallets/2", "Itt vannak a pénztárcák");
}

function loadGuestMenu() {
    let cont = document.getElementById("container");
    let usersG = document.createElement("a");
    usersG.setAttribute("href", "/wallets/1");
    usersG.innerHTML = "Ide kattints, Vendég";
    cont.appendChild(usersG);
}

function createMenu(place, link, text) {
    let clickMe = document.createElement("a");
    clickMe.setAttribute("href", link);
    clickMe.innerHTML = text;
    place.appendChild(clickMe);
}