import { ColumnContent } from '../ColumnContent';
import { ColumnHeader } from '../ColumnHeader';
import style from './style.module.scss';

export const ColumnContainer = (props : any) => {
    return (
        <div className={style.columnContainer}>
            <ColumnHeader title={props.title}/>
            <ColumnContent elements={props.content}></ColumnContent>
        </div>
    )
};