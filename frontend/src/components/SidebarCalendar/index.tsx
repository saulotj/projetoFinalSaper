import style from './style.module.scss';
import { SidebarCalendarHelper } from '../../Helper/SideCalendarHelper';
import { useEffect, useState } from 'react';

export const SidebarCalendar = () => {
    const [mainDate, setMainDate] = useState(new Date());

    const [date, setDate] = useState(SidebarCalendarHelper.updateDate(mainDate));

    useEffect(() => {
        setDate(SidebarCalendarHelper.updateDate(mainDate));
    }, [mainDate]);

    

    const [days, setDays] =
        useState(SidebarCalendarHelper.daysInMonth(date.month, date.year));


    return (
        <div>
            {date.numDaysInMonth}
        </div>
    )
}