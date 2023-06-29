import style from './style.module.scss';
import arrowNext from '../../../public/img/arrowNext.svg';
import arrowPrevious from '../../../public/img/arrowPrevious.svg';

export const SideNavigatorBtn = () => {
    return (
        <div className={style.sideNavigatorBtn}>
            <button className={style.sideNav_arrowBtn}>
                <img src={arrowPrevious} alt="" />
            </button>
            <div>28/06</div>
            <button className={style.sideNav_arrowBtn}>
                <img src={arrowNext} className={style.arrowSvg} alt="" />
            </button>
        </div>
    );
}