// loadAdminMenu();
createForm();

function createForm() {
    let form = document.getElementById("form");
    let pcash = document.createElement("p");
    pcash.innerHTML = "Enter cash amount";
    let pcard = document.createElement("p");
    pcard.innerHTML = "Enter card amount";
    let cashForm = document.createElement("input");
    cashForm.setAttribute("type", "text");
    cashForm.setAttribute("name", "cash");
    let cardForm = document.createElement("input");
    cardForm.setAttribute("type", "text");
    cardForm.setAttribute("name", "card");
    form.appendChild(pcash);
    form.appendChild(cashForm);
    form.appendChild(pcard);
    form.appendChild(cardForm);
}