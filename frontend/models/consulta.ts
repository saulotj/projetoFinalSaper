import { Medico } from "./medico";
import { Paciente } from "./paciente";
import { Recepcionista } from "./recepcionista";

export interface Consulta {

    id: number;
    data: Date;
    status: String;
    horario: String;
    paciente: Paciente;
    recepcionista: Recepcionista;
    medico: Medico;
    cheagada_at: String;
    atendimento_at: String;
    created_at: String;
    observacoes: string | null;

}