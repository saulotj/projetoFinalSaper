
import { SidebarCalendar } from '../SidebarCalendar';
import { SidebarOptions } from '../SidebarOptions';
import style from './style.module.scss';
import axios from 'axios';



export const Sidebar = () => {

// Disable CORS globally for all requests
axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';

// Set the username and password headers
axios.defaults.headers.common['Authorization'] = 'Basic ' + btoa('admin:123');
    return (
        <div className={style.sidebar}>
            {/*<SideNavigator/>*/}
            <SidebarOptions/>
            <SidebarCalendar/>
        </div>
    )
};