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
    <FindDoctor/>
    <NavbarComponent/>
    <Home>
      <Sidebar/>
      <Agenda/>
    </Home>
  </React.StrictMode>
);

