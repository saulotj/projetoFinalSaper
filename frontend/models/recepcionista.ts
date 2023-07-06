import { Consulta } from './consulta'

export interface Recepcionista {

    id: number;
    nome: String;
    email: String;
    senha: String;
    created_at: String;
    consulta: Consulta[] | null;

}