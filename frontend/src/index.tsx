import React from 'react';
import ReactDOM from 'react-dom/client';
import FindDoctor from './forms/FindDoctor.js'
import './index.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Agenda } from './components/Agenda';
import { NavbarComponent } from './components/Navbar';
import { Sidebar } from './components/Sidebar/Sidebar';
import { Home } from './templates/Home';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);

root.render(
  <React.StrictMode>
<<<<<<< HEAD
    <FindDoctor/>
    <HelloWorld/>
=======
    <NavbarComponent/>
    <Home>
      <Sidebar/>
      <Agenda/>
    </Home>
>>>>>>> 8d152e1decc8a85905b656c125467a49e6ee6d74
  </React.StrictMode>
);

