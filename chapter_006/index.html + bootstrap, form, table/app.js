let inputs = [];
let addRowButton = $('#add_row');


function addRow(name) {
    $('#table tr:last').after('<tr><td>' + name + '</td></tr>')
}

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

addRowButton.click(() => {
    let name = $('#name').val();
    if(name.length) {
        addRow(name);
    }
});



