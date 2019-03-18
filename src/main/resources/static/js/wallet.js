// loadAdminMenu();
createForm();

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
    createInput(form, "text", "cash", "cash-id");
    form.appendChild(pcard);
    createInput(form, "text", "card", "card-id");
    form.appendChild(br);

    let submitButton = document.createElement("input");
    submitButton.setAttribute("type", "submit");
    submitButton.setAttribute("id", "submit-button");
    submitButton.setAttribute("name", "OK");
    submitButton.setAttribute("value", "Mehet");
    submitButton.onclick = function() {
        console.log("Rám kattintottál");
        updateWallet();
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