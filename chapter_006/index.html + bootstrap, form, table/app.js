let inputs = [];

function validation() {
    $('input')
        .filter((i, v) => v.value === '')
        .each((i, v) => inputs.push(' ' + v.name));

    if (inputs.length > 0) {
        alert('Pleas enter' + inputs)
    }
    inputs = [];
}

$('#form').submit(e => {
    validation();
    e.preventDefault();
});


