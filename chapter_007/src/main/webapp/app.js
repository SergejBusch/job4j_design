const btn = document.querySelector('button');
const emailInput = document.querySelector('input');
const para = document.querySelector('p');

btn.addEventListener('click', sendGreeting);

async function sendGreeting(e) {
    e.preventDefault();
    try {
        const response = await fetch(`http://localhost:8080/web/greet?name=${emailInput.value}`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'text/plain',
                },
            });
        if (response.status >= 400) {
            throw new Error("Bad response from server");
        }

        para.innerText = await response.text();
    } catch(e)  {
        para.innerText = e;
    }

}