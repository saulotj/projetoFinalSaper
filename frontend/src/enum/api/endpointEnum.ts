export const endpointEnum = {
    getRootAdmin : "http://localhost:8080/administrador/1",
    getMedicoById : (id: (string| number)) => {
        return `http://localhost:8080/medico/${id}`;
    },
    getPacienteById : (id: (string| number)) => {
        return `http://localhost:8080/paciente/${id}`;
    },
    getRecepById : (id: (string| number)) => {
        return `http://localhost:8080/recepcionista/${id}`;
    }
};