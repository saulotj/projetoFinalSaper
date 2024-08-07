import style from './style.module.scss';
import { Button } from 'react-bootstrap';
import FindDoctor from '../../../forms/FindDoctor';
import CreateDoctor from '../../../forms/CreateDoctor';
import FindPatient from '../../../forms/FindPatient';
import AgendarConsulta from '../../agendarConsulta/agendarConsulta';
import Popup from 'reactjs-popup';
import CadastrarPaciente from '../../../cadastrarNovoPaciente/cadastrarNovosPacientes';
import axios from 'axios';


export const SidebarOptions = () => {

  // Disable CORS globally for all requests
  axios.defaults.headers.common['Authorization'] = 'Basic ' + btoa('admin:123');
  axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';

// Set the username and password headers


  

  return (
    <div className={style.sidebarOptions}>
      {/* <Popup trigger={<Button className={style.button} variant='secondary'> Novo Usuário </Button>} position="right center">
      <CreateUsers />
  </Popup>*/}  
      <Popup trigger={<Button className={style.button} variant='secondary'> Agendar Consulta </Button>} position="right center">
        <AgendarConsulta />
      </Popup>
      <Popup trigger={<Button className={style.button} variant='secondary'> Cadastrar Paciente </Button>} position="right center">
        <CadastrarPaciente />
      </Popup>
      <Popup trigger={<Button className={style.button} variant='secondary'> Cadastrar Médico </Button>} position="right center">
        <CreateDoctor />
      </Popup>
      <Popup trigger={<Button className={style.button} variant='secondary'> Encontrar Médico </Button>} position="right center">
        <FindDoctor />
      </Popup>
      <Popup trigger={<Button className={style.button} variant='secondary'> Encontrar Paciente </Button>} position="right center">
        <FindPatient />
      </Popup>
    </div>
  );
};
