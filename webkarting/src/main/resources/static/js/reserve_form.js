function generarCamposUsuarios(cantidad) {
    const contenedorUsuarios = document.getElementById('contenedorUsuarios');
    contenedorUsuarios.innerHTML = ''; // Limpiar el contenedor
    
    for (let i = 1; i <= cantidad; i++) {
        const usuarioDiv = document.createElement('div');
        
        if(i == 1){
            usuarioDiv.className = 'col-md-12';
            usuarioDiv.innerHTML = `
            <div class="row round-border mx-2 my-3 p-3" id="Usuario${i}" style="background-color: #aa1a26;">
                <h3 class="text-white" style="text-align: center;">Usuario${i} (Representante)</h3> 
                <div class="col-md-6" style="text-align: center; font-size: 19px;">
                    <div class="row py-3"><label for="name${i}" class="text-white">Nombre:</label></div>
                    <div class="row py-3"><label for="surname${i}" class="text-white">Apellidos:</label></div>
                    <div class="row py-3"><label for="dni${i}" class="text-white">DNI:</label></div>
                    <div class="row py-3"><label for="mail${i}" class="text-white">Correo:</label></div>
                    <div class="row py-3"><label for="phone_number${i}" class="text-white">Telefono:</label></div>
                </div>   
                <div class="col-md-6"> 
                    <div class="row py-3"><input id="name${i}" type="text" style="max-width: 90%;" required></div>
                    <div class="row py-3"><input id="surname${i}" type="text" style="max-width: 90%;" required></div>
                    <div class="row py-3"><input id="dni${i}" type="text" style="max-width: 90%;" required></div>
                    <div class="row py-3"><input id="mail${i}" type="text" style="max-width: 90%;" required></div>
                    <div class="row py-3"><input id="phone_number${i}" type="text" style="max-width: 90%;" required></div>
                </div>
            </div>`;
        }else{
            usuarioDiv.className = 'col-md-6';
            usuarioDiv.innerHTML = `
            <div class="row round-border mx-2 my-3 p-3" id="Usuario${i}" style="background-color: #aa1a26;">
                <h3 class="text-white" style="text-align: center;">Usuario${i}</h3> 
                <div class="col-md-6" style="text-align: center; font-size: 19px;">  
                    <div class="row py-3"><label for="name${i}" class="text-white">Nombre:</label></div>
                    <div class="row py-3"><label for="surname${i}" class="text-white">Apellidos:</label></div>
                    <div class="row py-3"><label for="dni${i}" class="text-white">DNI:</label></div>
                </div>   
                <div class="col-md-6">  
                    <div class="row py-3"><input id="name${i}" type="text" style="max-width: 90%;" required></div>
                    <div class="row py-3"><input id="surname${i}" type="text" style="max-width: 90%;" required></div>
                    <div class="row py-3"><input id="dni${i}" type="text" style="max-width: 90%;" required></div>
                </div>
            </div>`;
        }
        contenedorUsuarios.appendChild(usuarioDiv);
    }
}

// Escuchar cambios en el select
document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('numberPlayers').addEventListener('change', getNumberPlayersSelect)
});

function getNumberPlayersSelect(){
    const cantidadJugadores = parseInt(this.value);
    if (cantidadJugadores > 0) {
        generarCamposUsuarios(cantidadJugadores);
    } else {
        document.getElementById('contenedorUsuarios').innerHTML = '';
    }
}

function submitPress(event){
    event.preventDefault();
    const nPlayersInput = document.getElementById('numberPlayers');
    const numPlayers = nPlayersInput.value;
    const dateValue = document.getElementById('fecha').value;
    const valuesUsers = getValuesUsers(numPlayers);
    for(let users = 1; users <= numPlayers; users++){
        if(users === 1){        
            const emailRegExp = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailRegExp.test(valuesUsers[0][3])) {
                alert('Por favor ingresa un correo electrónico válido');
                return;
            }   
        }
        //Here we will do the repected validations.
        //Hour
    }

    
    const data = {
        "numUsers" : numPlayers,
        "date_hour" : dateValue,
        "listUsers" : valuesUsers.map(user => {
            const userData = {
                "dni" : user[2],
                "nombre": user[0],
                "apellidos": user[1],
                "correo" : user[3],
                "telefono" : user[4],
            };
            return userData
        })
    };
    console.log(data);
    const URL_BACKEND = 'http://127.0.0.1:8080';
    
    const url = URL_BACKEND + '/Reserve'; // URL EndPoint backend
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    };
    console.log(JSON.stringify(data));

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

function getValuesUsers(nPlayers){
    const inputAux = [];
    for(let i = 1;i<=nPlayers;i++)
    inputAux.push(getValues(i));
    
    return inputAux;
}

function getValues(user){
    let inputUser = [];
    inputUser.push(document.getElementById('name' + user).value);
    inputUser.push(document.getElementById('surname' + user).value);
    inputUser.push(document.getElementById('dni' + user).value);
    if(user == 1){
        inputUser.push(document.getElementById('mail' + user).value);
        inputUser.push(document.getElementById('phone_number' + user).value);
    }

    return inputUser;
}
