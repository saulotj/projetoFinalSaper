import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Agenda } from './components/Agenda';
import { NavbarComponent } from './components/Navbar';
import { Sidebar } from './components/Sidebar/Sidebar';
import axios from 'axios';

// Disable CORS globally for all requests
axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';

// Set the username and password headers
axios.defaults.headers.common['username'] = 'admin';
axios.defaults.headers.common['password'] = '123';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);

root.render(
  <React.StrictMode>
    <NavbarComponent/>
    
      <Sidebar/>
      <Agenda/>
      
  </React.StrictMode>
);
