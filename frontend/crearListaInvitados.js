/*
const params = new URLSearchParams(window.location.search);
const idInvitado = params.get("id");
async function cargarInvitado() {
    if (!idInvitado) {
        console.warn("No se envío ID en la URL")
        return;
    }
    try {
        const response = await fetch(`http://127.0.0.1:8083/rsvp/buscar/${idInvitado}`);
        if (!response.ok) {
            console.error("Invitado o encontrado");
            return
        }
        const invitado = await response.json();

        // se muetra en tarjeta principal
        document.getElementById("nombre-invitado").textContent = invitado.nombre;
        document.getElementById("pases-invitado").textContent = "Pases: " + invitado.acompanantes;

        //  seautollena el formulario
        document.getElementById("nombre").value = invitado.nombre;
        document.getElementById("acompanantes").value = invitado.acompanantes;
    } catch (error) {
        console.error("Error al cargar el invitado:", error)
    }
}
cargarInvitado();
*/

document.getElementById("form-crear-lista-invitados").addEventListener("submit", async function (e) {
    e.preventDefault();


    //const box_asistencia = document.querySelector("asistencia");
    const btn = document.querySelector("button[type='submit']");
    const msgSuccess = document.getElementById("msg-success");
    const msgError = document.getElementById("msg-error");

    msgSuccess.classList.add("d-none");
    msgError.classList.add("d-none");

    // Desactivar botón para evitar doble envío
    btn.disabled = true;
    btn.innerText = "Enviando...";

    try {
        const data = {
            nombre: document.getElementById("nombreinvitado").value,
            acompanantes: parseInt(document.getElementById("acompanantesinvitado").value) || 0,
            telefono: document.getElementById("telefonoinvitado").value,            
        };

        const response = await fetch("http://127.0.0.1:8083/admin", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            msgSuccess.classList.remove("d-none");
            a
            // limpia formulario
            document.getElementById("form-form-crear-lista-invitados").reset();
        } else {
            msgError.classList.remove("d-none");
        }

    } catch (error) {
        msgError.classList.remove("d-none");
    }
    // Reactivar botón
    btn.disabled = true;
    btn.innerText = "Enviado";

});
