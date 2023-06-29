import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { HelloWorld } from './components/HelloWorld';
import { NavbarComponent } from './components/Navbar';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);

root.render(
  <React.StrictMode>
    <NavbarComponent/>
    <HelloWorld/>
  </React.StrictMode>
);

