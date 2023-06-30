import { useState } from 'react';
import { ColumnContent } from '../ColumnContent';
import { ColumnHeader } from '../ColumnHeader';
import style from './style.module.scss';

export const ColumnContainer = (props : any) => {

    const currentDay = (date: string) => {
        const parsedDate = new Date(date + 'T00:00:00');
        const day = parsedDate.getDate();
        return day;
    };

    const [columnData, setColumnData] = useState({});
    const [title, setTitle] = useState< string | number | undefined >(currentDay(props.headerDay));

    return (
        <div className={style.columnContainer}>
            <ColumnHeader title={props.title? props.title:title}/>
            <ColumnContent size={props.size} isTimeCol={props.isTimeCol} consultas={props.content?props.content:[]}></ColumnContent>
        </div>
    )
};