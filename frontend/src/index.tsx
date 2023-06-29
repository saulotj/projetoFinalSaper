import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Agenda } from './components/Agenda/Agenda';
import { NavbarComponent } from './components/Navbar';
import { Sidebar } from './components/Sidebar/Sidebar';
import { Home } from './templates/Home';
import { Login } from './templates/Login';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);

/* root.render(
  <React.StrictMode>
    <NavbarComponent/>
    <Home>
      <Sidebar/>
      <Agenda/>
    </Home>
  </React.StrictMode>
); */

root.render(
  <React.StrictMode>
    <Login />
  </React.StrictMode>
);

