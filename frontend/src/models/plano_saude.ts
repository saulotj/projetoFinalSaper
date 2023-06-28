import { Paciente } from './paciente'

export interface PlanoDeSaude {

    id: number;
    nome: String;
    is_active: Boolean;
    created_at: String | null;
    paciente: Paciente[] | null;

}