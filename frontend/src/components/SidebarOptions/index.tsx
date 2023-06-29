import style from './style.module.scss';
import { Button } from 'react-bootstrap';
export const SidebarOptions = () => {
    return (
        <div className={style.sidebarOptions}>
            <Button className={style.button} variant='secondary'>Agendar consulta</Button>
            <Button className={style.button} variant='secondary'>Buscar paciente</Button>
            <Button className={style.button} variant='secondary'>Buscar médico</Button>
            <Button className={style.button} variant='secondary'>Fila de espera</Button>
        </div>
    );
}