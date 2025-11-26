const params = new URLSearchParams(window.location.search);
const token = params.get("t");

if (!token) {
    console.error("No se encontró token en la URL");
}

async function cargarDatosInvitado() {
    try {
        const response = await fetch(`http://127.0.0.1:8083/admin/vista/${token}`);      

        if (!response.ok) {
            throw new Error("Invitado no encontrado");
        }

        const invitado = await response.json();

        // Rellenar HTML
        document.getElementById("nombre-invitado").innerHTML = invitado.nombre;
        document.getElementById("pases-invitado").innerHTML = "Pases: " + invitado.acompanantes;

        // Rellenar FORMULARIO automáticamente
        document.getElementById("nombre").value = invitado.nombre;
        document.getElementById("acompanantes").value = invitado.acompanantes;

    } catch (error) {
        console.error(error);
    }
}

cargarDatosInvitado();