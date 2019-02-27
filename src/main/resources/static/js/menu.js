function loadAdminMenu() {
    let cont = document.getElementById("container");
    let usersA = document.createElement("a");
    usersA.setAttribute("href", "/users");
    usersA.innerHTML = "Ide kattints, User";
    cont.appendChild(usersA);
}

function loadGuestMenu() {
    let cont = document.getElementById("container");
    let usersG = document.createElement("a");
    usersG.setAttribute("href", "/wallets/1");
    usersG.innerHTML = "Ide kattints, Vendég";
    cont.appendChild(usersG);
}