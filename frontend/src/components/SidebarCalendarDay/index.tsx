import style from './style.module.scss';
export const SidebarCalendarDay = (props:any) => {
    return (
        <div className={`
        ${style.sidebarCalendarDay}
        ${props.isActive?style.active:''}
        `}>{props.num}</div>
    )
}