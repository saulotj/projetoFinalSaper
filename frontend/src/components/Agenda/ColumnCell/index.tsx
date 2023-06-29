import style from './style.module.scss';

export const ColumnCell = (prop: any) => {

    return (
        <div className={style.cell}>
            {prop.children}
        </div>
    )
};