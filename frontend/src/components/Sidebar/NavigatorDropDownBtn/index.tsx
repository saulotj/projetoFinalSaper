import style from './style.module.scss';
import Dropdown from 'react-bootstrap/Dropdown';
import DropdownButton from 'react-bootstrap/DropdownButton';

export const NavigatorDropDownBtn = () => {
    return (
        <Dropdown data-bs-theme="dark" className={style.sidebarDropDownBtn}>
            <Dropdown.Toggle id="dropdown-button-dark-example1" variant="secondary">
                Dia
            </Dropdown.Toggle>
            <Dropdown.Menu>
                <Dropdown.Item href="#/action-1" active>Dia</Dropdown.Item>
                <Dropdown.Item href="#/action-1">Mês</Dropdown.Item>
                <Dropdown.Item href="#/action-2">Ano</Dropdown.Item>
            </Dropdown.Menu>
        </Dropdown>
    );
};
