import React from 'react';
import ReactDOM from 'react-dom/client';
import FindDoctor from './forms/FindDoctor.js'
import './index.css';
import { HelloWorld } from './components/HelloWorld';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <React.StrictMode>
    <FindDoctor/>
    <HelloWorld/>
  </React.StrictMode>
);

