//  rellenar form con nombre y pases

window.addEventListener("DOMContentLoaded",()=>{
    const nombreInvitado = document.getElementById("data-listainvitado").innerText.trim();
    const pasesTexto = document.getElementById("pases-invitado").innerText.trim();
    const pases = pasesTexto.replace(/[^0-9]/g, ""); //  extrae solo numeros
    document.getElementById("nombre").value = nombreInvitado;
    document.getElementById("acompanantes").value = pases;
});

document.addEventListener("DOMContentLoaded", () => {
    const invitadoDiv = document.getElementById("data-listainvitado");

    if (listaInvitadoDiv) {
        const nombre = listaInvitadoDiv.dataset.nombre;
        const acomp = listaInvitadoDiv.dataset.acompanantes;

        document.getElementById("nombre").value = nombre;
        document.getElementById("acompanantes").value = acomp;
    }
});