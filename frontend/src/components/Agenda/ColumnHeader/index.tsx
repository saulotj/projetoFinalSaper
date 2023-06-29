import style from './style.module.scss';

export const ColumnHeader = ({title}: any) => {
    return (
        <div className={`${style.row} ${style.columnHeader}`}>
            {title}
        </div>
    )
};