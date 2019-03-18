// loadAdminMenu();
createForm();
let loggedUser = getUser();

function loadWalletsByUser(userid) {
    fetch("/wallets/" + userid)
    .then(function (request) {
              return request.json();
            })
            .then(function (jsonData) {
              console.log(jsonData);
              fillData(jsonData);
            });
}

function fillData(walletData) {
    let cashData = document.getElementById("cash-amount");
    let cardData = document.getElementById("card-amount");
    let cashSum = 0;
    let cardSum = 0;
    for (let i = 0; i < walletData.length; i++) {
        if (!walletData[i].deleted) {
            cashSum += walletData[i].cash;
            cardSum += walletData[i].card;
            fillWalletTable(walletData[i]);
        }
    }
    cashData.innerHTML = cashSum;
    cardData.innerHTML = cardSum;
    console.log("Sikeresen kiszámoltam az összes pénzt!");
}

function getUser() {
    return fetch("/user")
    .then(function retrieveUserData (response) {
        return response.json();
    })
    .then(function f(userData) {
        loggedUser = userData;
        loadWalletsByUser(loggedUser.id);
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

function fillWalletTable(walletData) {
    let tbody = document.getElementById("wallets-table");
    let trow = document.createElement("tr");
    let tdId = document.createElement("td");
    tdId.innerHTML = walletData.id;
    let tdCash = document.createElement("td");
    tdCash.innerHTML = walletData.cash;
    let tdCard = document.createElement("td");
    tdCard.innerHTML = walletData.card;
    let tdTotal = document.createElement("td");
    tdTotal.innerHTML = walletData.cash + walletData.card;
    let delButton = document.createElement("button");
    delButton.setAttribute("id", "delete-button");
    delButton.innerHTML = "Delete me";
    delButton.onclick = function() {deleteWallet(walletData.id)}
    trow.appendChild(tdId);
    trow.appendChild(tdCash);
    trow.appendChild(tdCard);
    trow.appendChild(tdTotal);
    trow.appendChild(delButton);
    tbody.appendChild(trow);
}

function deleteWallet(walletId) {
    if (confirm("Biztosan törölni akarod?")) {
        console.log(walletId);
        fetch('/wallets/delete?id='+ walletId, {
                method: 'DELETE',
                headers: {'Content-Type': 'application/json; charset=utf-8'}
            }).then(function getDeleteResponse(response) {
                             return response.json();
            }).then( function loadSuccessMessage(response) {
                      document.getElementById("message-p").innerHTML = response.message;
            });
    }
}