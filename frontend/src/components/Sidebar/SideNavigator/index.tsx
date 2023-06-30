import style from './style.module.scss';
import arrowNext from '../../../public/img/arrowNext.svg';
import arrowPrevious from '../../../public/img/arrowPrevious.svg';
import { useNavigate } from 'react-router';
import { Dropdown } from 'react-bootstrap';
import { useState } from 'react';
import { CalendarHelper } from '../../../Helper/CalendarHelper';

export const SideNavigator = () => {
    const [mainDate, setMainDate] = useState(new Date());
    const [date, setDate] = useState(CalendarHelper.updateDate(mainDate));
    const navigate = useNavigate();

    const handleToggleDay = () => { navigate('/agenda/day') }
    const handleToggleWeek = () => { navigate('/agenda/semana') }
    const handleToggleMonth = () => { navigate('/agenda/mes') }

    return (
        <div className={style.sideNavigator}>
            <Dropdown data-bs-theme="dark" className={style.dropdownContainer}>
                <Dropdown.Toggle id="dropdown-button-dark-example1" className={style.dropdownBtn}>
                    Semana
                </Dropdown.Toggle>
                <Dropdown.Menu align={"end"}>
                    <Dropdown.Item onClick={() => { handleToggleDay() }} href="">Dia</Dropdown.Item>
                    <Dropdown.Item onClick={() => { handleToggleWeek() }} href="" active>Semana</Dropdown.Item>
                    <Dropdown.Item onClick={() => { handleToggleMonth() }} href="">Mês</Dropdown.Item>
                </Dropdown.Menu>
            </Dropdown>
        </div>

    )
};