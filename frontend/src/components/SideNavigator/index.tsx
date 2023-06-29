import style from './style.module.scss';
import { NavigatorDropDownBtn } from '../NavigatorDropDownBtn';
import { SideNavigatorBtn } from '../SideNavigatorBtn';

export const SideNavigator = () => {
    return (
        <div className={style.sideNavBtnContainer}>
            <SideNavigatorBtn/>
            <NavigatorDropDownBtn/>
        </div>
    )
};