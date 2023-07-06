import { useContext, useEffect, useState } from 'react';
import style from './style.module.scss';
import { AgendaHelper } from '../../../Helper/AgendaHelper';
import { horarioEnum } from '../../../enum/horarios';
import { CalendarHelper } from '../../../Helper/CalendarHelper';
import { ColumnContainer } from '../ColumnContainer';
import { ApiConfig } from '../../../api/ApiConfig';
import { AuthContext } from '../../../store/AuthContext';

//const login = auth.credentials;
//const header = ApiConfig.getHeaderWithBasicLogin(login);

export const Agenda = () => {
    const auth = useContext(AuthContext);
    const [horarios, setHorarios] = useState(AgendaHelper.getHorarios(horarioEnum));

    const [mainDate, setMainDate] = useState(new Date());
    const [date, setDate] = useState(CalendarHelper.updateDate(mainDate));

    const [consultasByDay, setConsultasByDay] = useState([]);

    const weekLength = 5;

    const header = ApiConfig.getHeaderDevAccess();

    useEffect(() => {
        (async () => {
            const response = await fetchData();
            const days = response?.data;
            setConsultasByDay(days);
        })();
    }, [])

    const fetchData = async () => {
        return await AgendaHelper.fetchWeek(date.year, date.month, date.day, weekLength, header);
    };

    return (
        <div className={style.agenda}>
            <ColumnContainer isTimeCol={true} size={horarios?.length} content={horarios} title={"Horários"} />

            {consultasByDay.length > 0 ?
                consultasByDay.map((day: any, index: number) => {
                    return <ColumnContainer key={index} size={horarios?.length} content={day.consulta} headerDay={day.data} />
                }): 'Carregando'
            }

        </div>
    )
};