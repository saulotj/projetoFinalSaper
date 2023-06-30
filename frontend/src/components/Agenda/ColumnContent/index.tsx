import { ColumnCell } from '../ColumnCell';
import style from './style.module.scss';
import { horarioEnum } from '../../../enum/horarios';
import { useState } from 'react';
import { CellContent } from '../CellContent';

export const ColumnContent = (props: any) => {
    if (props.isTimeCol) {
        let body: any = [];
        body = props.consultas.map((el: any) => <ColumnCell key={el}>{el}</ColumnCell>);
        return <div className={style.columnContent}>{body}</div>;
    }

    const horarios: any[] = Object.values(horarioEnum);

    const column: any[] = [];

    for (let i = 0; i < horarios.length; i++) {
        const CellContents:any = [];
        const i2 = i + 1;

        props.consultas.forEach((consulta: any, index:number) => {
            if (consulta.horario == horarios[i] + ':00') {
                CellContents.push(<CellContent key={index + i} content={consulta} />);
            };
        });

        column.push(
            <ColumnCell key={i + i2}>
                {CellContents}
            </ColumnCell>
        );
    }

    return (
        <div className={style.columnContent}>{column}</div>
    )
};