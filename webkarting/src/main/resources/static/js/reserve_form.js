function generarCamposUsuarios(cantidad) {
    const contenedorUsuarios = document.getElementById('contenedorUsuarios');
    contenedorUsuarios.innerHTML = ''; // Limpiar el contenedor
    
    for (let i = 1; i <= cantidad; i++) {
        const usuarioDiv = document.createElement('div');
        
        if(i == 1){
            usuarioDiv.className = 'col-md-12';
            usuarioDiv.innerHTML = `
            <div class="row" id="Usuario${i}" style="background-color: #aa1a26;">
                <h3 class="text-white" style="text-align: center;">Usuario${i} (Representante)</h3> 
                <div class="col-md-6" style="text-align: center; font-size: 19px;">
                    <div class="row py-2"><label for="nombre${i}" class="text-white">Nombre:</label></div>
                    <div class="row py-2"><label for="surname${i}" class="text-white">Apellidos:</label></div>
                    <div class="row py-2"><label for="dni${i}" class="text-white">DNI:</label></div>
                    <div class="row py-2"><label for="correo${i}" class="text-white">Correo:</label></div>
                    <div class="row py-2"><label for="telefono${i}" class="text-white">Telefono:</label></div>
                </div>   
                <div class="col-md-6"> 
                    <div class="row py-2"><input id="nombre${i}" type="text" style="max-width: 90%;"></div>
                    <div class="row py-2"><input id="surname${i}" type="text" style="max-width: 90%;"></div>
                    <div class="row py-2"><input id="dni${i}" type="text" style="max-width: 90%;"></div>
                    <div class="row py-2"><input id="correo${i}" type="text" style="max-width: 90%;"></div>
                    <div class="row py-2"><input id="telefono${i}" type="text" style="max-width: 90%;"></div>
                </div>
            </div>`;
        }else{
            usuarioDiv.className = 'col-md-6';
            usuarioDiv.innerHTML = `
            <div class="row" id="Usuario${i}" style="background-color: #aa1a26;">
                <h3 class="text-white" style="text-align: center;">Usuario${i}</h3> 
                <div class="col-md-6" style="text-align: center; font-size: 19px;">  
                    <div class="row py-2"><label for="nombre${i}" class="text-white">Nombre:</label></div>
                    <div class="row py-2"><label for="surname${i}" class="text-white">Apellidos:</label></div>
                    <div class="row py-2"><label for="dni${i}" class="text-white">DNI:</label></div>
                </div>   
                <div class="col-md-6">  
                    <div class="row py-2"><input id="nombre${i}" type="text" style="max-width: 90%;"></div>
                    <div class="row py-2"><input id="surname${i}" type="text" style="max-width: 90%;"></div>
                    <div class="row py-2"><input id="dni${i}" type="text" style="max-width: 90%;"></div>
                </div>
            </div>`;
        }
        contenedorUsuarios.appendChild(usuarioDiv);
    }
}

// Escuchar cambios en el select
document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('numeroJugadores').addEventListener('change', function() {
        const cantidadJugadores = parseInt(this.value);
        if (cantidadJugadores > 0) {
            generarCamposUsuarios(cantidadJugadores);
        } else {
            document.getElementById('contenedorUsuarios').innerHTML = ''; // Limpiar el contenedor si se selecciona "Seleccionar cantidad de jugadores"
        }
    });
});

