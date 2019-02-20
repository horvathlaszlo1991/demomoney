console.log("Szia Géza");

setMessage();

function setMessage() {
    let field = document.getElementById('my-h1');
    field.innerHTML = 'Díszcsákány';
    console.log(field);
}