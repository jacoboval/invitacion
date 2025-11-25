//  rellenar form con nombre y pases
/*
window.addEventListener("DOMContentLoaded",()=>{
    const nombreInvitado = document.getElementById("nombre-invitado").innerText.trim();
    const pasesTexto = document.getElementById("pases-invitado").innerText.trim();
    const pases = pasesTexto.replace(/[^0-9]/g, ""); //  extrae solo numeros
    document.getElementById("nombre").value = nombreInvitado;
    document.getElementById("acompanantes").value = pases;
});
*/
document.addEventListener("DOMContentLoaded", () => {
    const invitadoDiv = document.getElementById("data-invitado");

    if (invitadoDiv) {
        const nombre = invitadoDiv.dataset.nombre;
        const acomp = invitadoDiv.dataset.acompanantes;

        document.getElementById("nombre").value = nombre;
        document.getElementById("acompanantes").value = acomp;
    }
});