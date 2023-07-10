
import { SidebarCalendar } from '../SidebarCalendar';
import { SidebarOptions } from '../SidebarOptions';
import style from './style.module.scss';
import axios from 'axios';



export const Sidebar = () => {

    return (
        <div className={style.sidebar}>
            {/*<SideNavigator/>*/}
            <SidebarOptions/>
            <SidebarCalendar/>
        </div>
    )
};