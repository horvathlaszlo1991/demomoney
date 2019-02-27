// loadAdminMenu();
createForm();

function createForm() {
    let form = document.getElementById("form");
    let br = document.createElement("br");
    let pcash = document.createElement("p");
    pcash.innerHTML = "Enter cash amount";
    let pcard = document.createElement("p");
    pcard.innerHTML = "Enter card amount";
    form.appendChild(pcash);
    createInput(form, "text", "cash");
    form.appendChild(pcard);
    createInput(form, "text", "card");
    form.appendChild(br);
    createInput(form, "submit", "OK");
}

function createInput(place, type, name) {
    let input = document.createElement("input");
    input.setAttribute("type", type);
    input.setAttribute("name", name);
    place.appendChild(input);
}