import { useState } from 'react';
import style from './style.module.scss';
import { AgendaHelper } from '../../../Helper/AgendaHelper';
import { horarioEnum } from '../../../enum/horarios';
import { ColumnCell } from '../ColumnCell';

export const Agenda = () => {
    const [horarios, setHorarios] = useState(AgendaHelper.getHorarios(horarioEnum));

    const Column = ({elements}: any) => {
        const body: any = [];
        elements.map((el: any) => {
            body.push(<ColumnCell key={el}>
                {el}
            </ColumnCell>);
        })
        return <div className={style.column}>{body}</div>
    }

    return (
        <div className={style.agenda}>
            {/* column */}
            <div className={style.column}>
                <div className={`${style.row} ${style.columnHeader}`}>
                    Horários
                </div>
                <Column elements={horarios}></Column>
            </div>

        </div>
    )
};