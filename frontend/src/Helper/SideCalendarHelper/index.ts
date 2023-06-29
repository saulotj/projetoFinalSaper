export const SidebarCalendarHelper = {
    isValidDate : (date : Date) => {
        return date instanceof Date && !isNaN(date.getTime());
    },
    daysInMonth : (month : number, year : number) => {
        return new Date(year, month + 1, 0).getDate();
    },
    addDays: (date : Date, days : number) => {
        var result = new Date(date);
        result.setDate(result.getDate() + days);
        return result;
    },
    updateDate : (mainDate: Date) => {
        return {
            date: mainDate,
            year: mainDate.getFullYear(),
            month: mainDate.getMonth(),
            day: mainDate.getDate(),
            numDaysInMonth: SidebarCalendarHelper.daysInMonth(mainDate.getMonth(), mainDate.getFullYear())
        };
    }
}