// loadAdminMenu();
createForm();
let loggedUser = getUser();

function loadWalletsByUser(userid) {

}

function getUser() {
    return fetch("/user")
    .then(function retrieveUserData (response) {
        return response.json();
    })
    .then(function f(userData) {
        loggedUser = userData;
        console.log(loggedUser);
        return userData;
    })
}

function createForm() {
    let form = document.getElementById("form");
    let br = document.createElement("br");
    let ptext = document.createElement("p");
    ptext.innerHTML = "Ezt pedig JavaScript oldalon";
    form.appendChild(ptext);
    let pcash = document.createElement("p");
    pcash.innerHTML = "Enter cash amount";
    let pcard = document.createElement("p");
    pcard.innerHTML = "Enter card amount";
    form.appendChild(pcash);
    createInput(form, "number", "cash", "cash-id");
    form.appendChild(pcard);
    createInput(form, "number", "card", "card-id");
    form.appendChild(br);

    let submitButton = document.createElement("input");
    submitButton.setAttribute("type", "submit");
    submitButton.setAttribute("id", "submit-button");
    submitButton.setAttribute("name", "OK");
    submitButton.setAttribute("value", "Mehet");
    submitButton.onclick = function() {
        console.log("Rám kattintottál");
        updateWallet();
        createWallet();
    }
    form.appendChild(submitButton);

}

function createInput(place, type, name, id) {
    let input = document.createElement("input");
    input.setAttribute("type", type);
    input.setAttribute("name", name);
    input.setAttribute("id", id);
    place.appendChild(input);
}


function updateWallet() {
    let cashInput = document.getElementById("cash-id");
    let cardInput = document.getElementById("card-id");
    console.log("Cash input: " + cashInput.value);
    console.log("Card input: " + cardInput.value);
}

function createWallet() {
    let cashInput = document.getElementById("cash-id");
    let cardInput = document.getElementById("card-id");
    let walletInput = {"cash": cashInput.value, "card": cardInput.value, "userId": loggedUser.id, "deleted": false};
    console.log(walletInput);
    fetch('/wallets/create', {
                    method: 'POST',
                    headers: {'Content-Type': 'application/json; charset=utf-8'},
                    body: JSON.stringify(walletInput)
                }).then(function getCreationResponse(response) {
                                 return response.json();
                      }).then( function loadSuccessMessage(response) {
                          document.getElementById("message-p").innerHTML = response.message;
                  });

}