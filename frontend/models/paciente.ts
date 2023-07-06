import { Consulta } from "./consulta";

export interface Paciente {

   id: number;
   nome: String;
   cpf: String;
   responsavel: String | null;
   telefone: String;
   endereco: String;
   dataNascimento: Date;
   email: String;
   observacao: String | null;
   consultas: Consulta[] | null;

}