import { useState } from 'react';
import style from './style.module.scss';
export const CellContent = ({content} : any) => {
    const [status, setStatus] = useState();

    return (
        <div className={style.cellConsulta}>
            {content.id}
        </div>
    )
}