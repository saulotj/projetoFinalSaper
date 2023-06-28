import { Consulta } from "./consulta";

export interface Calendario {

    id: number;
    feriado: boolean;
    consulta: Consulta[];
    diaSemana: string;
    data: String;

}