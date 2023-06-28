import { Consulta } from './consulta'

export interface Medico {

    id: number;
    nome: String;
    email: String;
    senha: String;
    telefone: String;
    crm: String;
    especialidade: String;
    consulta: Consulta[] | null;
    created_at: String | null;

}