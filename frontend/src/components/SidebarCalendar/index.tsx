import style from './style.module.scss';
import { SidebarCalendarHelper } from '../../Helper/SideCalendarHelper';
import { SidebarCalendarDay } from '../SidebarCalendarDay';
import { useEffect, useState } from 'react';

export const SidebarCalendar = () => {
    const [mainDate, setMainDate] = useState(new Date());
    const [date, setDate] = useState(SidebarCalendarHelper.updateDate(mainDate));
    
    const SideCalendar = () => {
        const Component = [];
        const daysLetters = ['D','S','T','Q','Q','S','S'];

        daysLetters.forEach((el, index) => {
            Component.push(<SidebarCalendarDay num={el} key ={el+index}/>);
        })

        for (let i = 1; i <= date.numDaysInMonth; i++) {
            if (i == date.day) {
                Component.push( <SidebarCalendarDay isActive={true} num={i} key ={i}/> );
                continue;
            }
            Component.push( <SidebarCalendarDay isActive={false} num={i} key ={i}/> );
        }
        return <div className={style.sideCalendar}>{Component}</div>;
    }

    useEffect(() => {
        setDate(SidebarCalendarHelper.updateDate(mainDate));
    }, [mainDate]);

    return (
        <div>
            <SideCalendar/>
        </div>
    )
}