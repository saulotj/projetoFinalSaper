import { useState } from 'react';
import style from './style.module.scss';
import { AgendaHelper } from '../../../Helper/AgendaHelper';
import { horarioEnum } from '../../../enum/horarios';
import { CalendarHelper } from '../../../Helper/CalendarHelper';
import { ColumnContainer } from '../ColumnContainer';

export const Agenda = () => {
    const [horarios, setHorarios] = useState(AgendaHelper.getHorarios(horarioEnum));
    const [mainDate, setMainDate] = useState(new Date());
    const [date, setDate] = useState(CalendarHelper.updateDate(mainDate));
    
    const mockCell = Array.apply(null, Array(horarios.length))

    for (let i = 0; i < mockCell.length; i ++) {
        mockCell[i] = '';
    }

    return (
        <div className={style.agenda}>
            <ColumnContainer content={horarios} title={"Horários"}/>
            <ColumnContainer content={mockCell} title={date.day}/>
            <ColumnContainer content={mockCell} title={date.day}/>
            <ColumnContainer content={mockCell} title={date.day}/>
            <ColumnContainer content={mockCell} title={date.day}/>
            <ColumnContainer content={mockCell} title={date.day}/>
            <ColumnContainer content={mockCell} title={date.day}/>
        </div>
    )
};