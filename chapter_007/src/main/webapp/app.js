const btn = document.querySelector('button');
const emailInput = document.querySelector('input');
const para = document.querySelector('p');

btn.addEventListener('click', sendGreeting);

async function sendGreeting(e) {
    e.preventDefault();
    try {

        const d = JSON.stringify({
            name : emailInput.value,
        });
        let uri = encodeURI(`http://localhost:8080/web/greet?data=${d}`);
        const response = await fetch(uri, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                },
            });
        if (response.status >= 400) {
            throw new Error("Bad response from server");
        }
        let dataResponse =  await response.json();
        para.innerText =  dataResponse.greet;
    } catch(e)  {
        para.innerText = e;
    }

}