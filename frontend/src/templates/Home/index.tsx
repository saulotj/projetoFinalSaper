import { Outlet } from "react-router";
import { NavbarComponent } from "../../components/Navbar";
import { Sidebar } from "../../components/Sidebar/Sidebar";
import { ConsultaContext } from "../../store/ConsultaContext";
import { useState } from "react";

export const Home = () => {
    const [consulta, setConsulta] = useState<any>();
    const [medico, setMedico] = useState<any>();
    const [paciente, setPaciente] = useState<any>();
    const [recepcionista, setRecepcionista] = useState<any>();

    return (
        <>
            <NavbarComponent />
            <ConsultaContext.Provider value={
                {
                    consulta, setConsulta, medico, setMedico,
                    paciente, setPaciente, recepcionista, setRecepcionista
                }
            }>
                <div className='d-flex'>
                    <Sidebar />
                    <Outlet />
                </div>
            </ConsultaContext.Provider>
        </>
    )
};