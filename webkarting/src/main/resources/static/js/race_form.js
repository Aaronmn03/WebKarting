function generarCamposDrivers(cantidad) {
    const contenedorUsuarios = document.getElementById('containerDrivers');
    contenedorUsuarios.innerHTML = '';
    
    for (let i = 1; i <= cantidad; i++) {
        const driverDiv = document.createElement('div');
        
        driverDiv.className = 'col-md-12';
        driverDiv.innerHTML = `
            <div class="row grey-box mx-2 my-3 p-3" id="Usuario${i}" >
                <h3 class="text-white" style="text-align: center;">Corredor ${i}</h3> 
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
                <div id="UsuarioLaps${i}" class="p-3 col-md-12"></div>
            </div>`;
        contenedorUsuarios.appendChild(driverDiv);  
    }
    getNumberLaps();
}

function generateContainerLaps(laps,idUser){
    const contenedorLaps = document.getElementById(`UsuarioLaps${idUser}`);
    contenedorLaps.innerHTML = '';

    for(let i = 1; i <= laps;i++){
        const lapDiv = document.createElement('div');

        lapDiv.className = 'row';
        lapDiv.innerHTML = `
        <div class="ligthGrey-box mx-2 my-1 p-2" id="Lap${i}-${idUser}">
        <h4 class="text-white" style="text-align: center;">Vuelta ${i}</h4> 
            <div class="row">
                <div class="col-md-4" style="font-size: 14px;">  
                    <label for="Sect1.${i}-${idUser}" class="text-white">Sector1:</label>
                    <input id="Sect1.${i}-${idUser}" type="text" style="max-width: 90%;" required>
                </div>
                <div class="col-md-4" style="font-size: 14px;">  
                    <label for="Sect2.${i}-${idUser}" class="text-white">Sector2:</label>
                    <input id="Sect2.${i}-${idUser}" type="text" style="max-width: 90%;" required>
                </div>
                <div class="col-md-4" style="font-size: 14px;">  
                    <label for="Sect3.${i}-${idUser}" class="text-white">Sector3:</label>
                    <input id="Sect3.${i}-${idUser}" type="text" style="max-width: 90%;" required>
                </div>
            </div>
    </div>
    

        `;
        contenedorLaps.appendChild(lapDiv);
    }
}

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('numberDivers').addEventListener('change', getNumberDriversSelected)
    document.getElementById('numLaps').addEventListener('change', getNumberLaps)
});

function getNumberDriversSelected(){
    const cantidadDrivers = parseInt(this.value);
    if (cantidadDrivers > 0) {
        generarCamposDrivers(cantidadDrivers);
    } else {
        document.getElementById('containerDrivers').innerHTML = '';
    }
}

function getNumberLaps(){

    const numDrivers = document.getElementById('numberDivers').value;
    const cantidadLaps = document.getElementById('numLaps').value;

    for(let i = 1; i <= numDrivers; i++){
        generateContainerLaps(cantidadLaps,i);
    }   
}

function submitPressRace(event){
    event.preventDefault();
    const nDrivers = document.getElementById('numberDivers').value;
    const nLaps = document.getElementById('numLaps').value;
    let usersDatas = []
    for(let i = 1; i<=nDrivers ; i++){
        let lapsUser = [];
        for(let j = 1; j<=nLaps ; j++){
            lapsUser.push(new Lap(document.getElementById('Sect1.' + i +'-' + j).value,document.getElementById('Sect2.' + i +'-' + j).value,document.getElementById('Sect3.' + i +'-' + j).value));
        }
        usersDatas.push(new Usuario(document.getElementById('name' + i).value,document.getElementById('surname' + i).value,document.getElementById('dni' + i).value,lapsUser));
    }
    
    
    const data = {
        "numberLaps" : nLaps,
        "listDrivers" : usersDatas
    }

    const URL_BACKEND = 'http://127.0.0.1:8080';
    
    const url = URL_BACKEND + '/api/Race/'; // URL EndPoint backend
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

function Usuario(name,surname,dni,listLaps){
    this.name = name;
    this.surname = surname;
    this.dni = dni;
    this.listLaps = listLaps;
    for(let i = 0; i<  listLaps.length ; i++){
        totalTime = listLaps[i].totalTime;
    }
    if(!checkDNI(dni)){
        alert('Por favor ingresa un DNI valido');
        return;
    }
}

function Lap(sector1, sector2, sector3) {
    this.timeSect1 = sector1;
    this.timeSect2 = sector2;
    this.timeSect3 = sector3;
    this.totalTime = parseInt(sector1) + parseInt(sector2) + parseInt(sector3);
}

function checkDNI(dni){
    var dniRegex = /^[0-9]{8}[a-zA-Z]$/;
    
    if (dniRegex.test(dni)) {
        var numbers = dni.slice(0, -1);
        var letter = dni.slice(-1).toUpperCase();
        var index = parseInt(numbers) % 23;
        var letters = 'TRWAGMYFPDXBNJZSQVHLCKE';
        
        if (letter === letters.charAt(index)) {
            return true;
        } else {
            return false;
        }
    } else {
        return false;
    }
}