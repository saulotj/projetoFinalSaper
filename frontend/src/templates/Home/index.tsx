import { Outlet } from "react-router";
import { Agenda } from "../../components/Agenda/Agenda";
import { NavbarComponent } from "../../components/Navbar";
import { Sidebar } from "../../components/Sidebar/Sidebar";

export const Home = () => {
    return (
        <>
            <NavbarComponent />
            <div className='d-flex'>
                <Sidebar />
                <Outlet />
            </div>
        </>
    )
};