import { ColumnCell } from '../ColumnCell';
import style from './style.module.scss';

export const ColumnContent = ({elements}: any) => {
    const body: any = [];

    elements.map((el: any) => {
        body.push(
            <ColumnCell key={el}>
                {el}
            </ColumnCell>
        );
    })

    return (    
        <div className={style.columnContent}>{body}</div>
    )
};