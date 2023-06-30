import { Api } from "../../api/Api";

export const AgendaHelper = {
    getHorarios: (horarios: any) => {
        return Object.values(horarios);
    },
    fetchWeek: async (year: number, month: number, day: number, weekLengh: number, header:any) => {
        const response = await Api.get(`http://localhost:8080/calendario/${year}/${month + 1}/${day}?interval=${weekLengh}`, header);
        return response;
    },
};