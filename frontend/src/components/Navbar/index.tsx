import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import Offcanvas from 'react-bootstrap/Offcanvas';
import userLogo from '../../public/img/user-96.png';
import style from './style.module.scss';
import { useState } from 'react';


export const NavbarComponent = () => {
    

    const dateOptions : Intl.DateTimeFormatOptions = {
        weekday: "long",
        day: "numeric",
        month: "long",
        year: "numeric",
    };

    const [date, setDate] = useState<String>(new Date().toLocaleDateString("pt-Br", dateOptions));

    return (
        <Navbar expand="md" className="bg-body-tertiary mb-3">
            <Container fluid>
                <Navbar.Brand href="#">Clinica Bem Estar</Navbar.Brand>
                <Navbar.Toggle aria-controls={`offcanvasNavbar-expand-md`} />
                <Navbar.Offcanvas
                    id={`offcanvasNavbar-expand-md`}
                    aria-labelledby={`offcanvasNavbarLabel-expand-md`}
                    placement="end"
                >
                    <Offcanvas.Header closeButton>
                        <Offcanvas.Title id={`offcanvasNavbarLabel-expand-md`}>
                            Clínica Bem Estar
                        </Offcanvas.Title>
                    </Offcanvas.Header>
                    <Offcanvas.Body>
                        <Nav className="justify-content-end flex-grow-1 pe-3">
                            <div className={style.today_date}>
                                {date}
                            </div>
                            <img src={userLogo} className={style.user_icon} alt="" />
                            <NavDropdown align={"end"} className='mt-auto mb-auto'
                                title="Anônimo"
                                id={`offcanvasNavbarDropdown-expand-md`}
                            >
                                <NavDropdown.Item href="#action3">Editar perfil</NavDropdown.Item>
                                <NavDropdown.Divider />
                                <NavDropdown.Item href="#action5">
                                    Sair
                                </NavDropdown.Item>
                            </NavDropdown>
                        </Nav>
                    </Offcanvas.Body>
                </Navbar.Offcanvas>
            </Container>
        </Navbar>
    )
};