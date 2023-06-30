import style from './style.module.scss';

export const ColumnCell = (prop: any) => {

    return (
        <div className={style.cell}>
            {<div className={style.cellContent}>{prop.children}</div>}
        </div>
    )
};