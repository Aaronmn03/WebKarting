function submitPressContact(event){
    event.preventDefault();
    const name = document.getElementById('name').value;
    const mail = document.getElementById('mail').value;
    const message = document.getElementById('message').value;
    
    
    const data = {
        "name" : name,
        "mail" : mail,
        "message" : message
    }

    const URL_BACKEND = 'http://127.0.0.1:8080';
    
    const url = URL_BACKEND + '/api/Contact/'; // URL EndPoint backend
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    };

    console.log(options.body);
    

    fetch(url, options)
    .then(response => {
        if (!response.ok) {     //This check if the server is connected OK
            throw new Error('Error al enviar los datos al servidor');
        }
        return response.json();
    })
    .then(data => {
        console.log('Respuesta del servidor:', data);
        
    })
    .catch(error => {
        console.error('Error:', error);
    });
}