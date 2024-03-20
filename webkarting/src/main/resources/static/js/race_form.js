function generarCamposDrivers(cantidad) {
    const contenedorUsuarios = document.getElementById('containerDrivers');
    contenedorUsuarios.innerHTML = '';
    
    for (let i = 1; i <= cantidad; i++) {
        const driverDiv = document.createElement('div');
        
        driverDiv.className = 'col-md-12';
        driverDiv.innerHTML = `
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

        contenedorUsuarios.appendChild(driverDiv);
    }
}

function generateContainerLaps(laps,idUser){
    const contenedorLaps = document.getElementById('Usuario${i}');
    contenedorLaps.innerHTML = '';

    for(let i = 1; i <= laps;i++){
        const lapsDiv = document.createElement('div');

        lapsDiv.className = 'col-md-12';
        lapsDiv.innerHTML = `
            <div class="row round-border mx-2 my-3 p-3" id="Lap${i}-${idUser}" style="background-color: #aa1a26;">
             <h3 class="text-white" style="text-align: center;">Vuelta${i}$</h3> 
             <div class="col-md-6" style="text-align: center; font-size: 19px;">  
                <div class="row py-3"><label for="Sect1.${i}-${idUser}" class="text-white">Sector1:</label></div>
                <div class="row py-3"><label for="Sect2.${i}-${idUser}" class="text-white">Sector2:</label></div>
                <div class="row py-3"><label for="Sect3.${i}-${idUser}" class="text-white">Sector3:</label></div>
            </div>   
            <div class="col-md-6">  
                <div class="row py-3"><input id="Sect1.${i}-${idUser}" type="text" style="max-width: 90%;" required></div>
                <div class="row py-3"><input id="Sect2.${i}-${idUser}" type="text" style="max-width: 90%;" required></div>
                <div class="row py-3"><input id="Sect3.${i}-${idUser}" type="text" style="max-width: 90%;" required></div>
            </div>
        `;

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
    const cantidadLaps = parseInt(this.value);
    const numDrivers = document.getElementById('numberDivers').value;
    if (cantidadLaps > 0) {
        for(let i = 1; i <= numDrivers; i++){
            generateContainerLaps(cantidadLaps,i);
        }
        
    } else {
        document.getElementById('containerLaps').innerHTML = '';
    }
}