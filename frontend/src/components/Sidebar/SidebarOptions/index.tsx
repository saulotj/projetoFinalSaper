import style from './style.module.scss';
import { Button } from 'react-bootstrap';
import React, { useState } from 'react';
import FindDoctor from '../../../forms/FindDoctor';
import CreateDoctor from '../../../forms/CreateDoctor';
import CreateUsers from '../../../forms/CreateUsers';
import FindPatient from '../../../forms/FindPatient';
import AgendarConsulta from '../../agendarConsulta//agendarConsulta';
import Popup from 'reactjs-popup';
import CadastrarPaciente from '../../../cadastrarNovoPaciente/cadastrarNovosPacientes';

export const SidebarOptions = () => {
  enum FormType {
    Medico = 'newmedico',
    Paciente = 'newpaciente',
    findMedico = 'achamedico',
    findPaciente = 'achapaciente'
  }

  const [activeForm, setActiveForm] = useState<FormType | null>(null);
  const [searchBarVisible, setSearchBarVisible] = useState<boolean>(false);

  const handleFormChange = (formType: FormType) => {
    if (activeForm === formType) {
      // Se o botão for clicado novamente, esconde a barra de busca
      setActiveForm(null);
      setSearchBarVisible(false);
    } else {
      setActiveForm(formType);
      setSearchBarVisible(true);
    }
  };

  const renderForm = () => {
    switch (activeForm) {
      case FormType.Medico:
        return <FindDoctor />;
      case FormType.Paciente:
        return <FindPatient />;
      default:
        return null;
    }
  };

  return (
    <div className={style.sidebarOptions}>
      <Popup trigger={<Button className={style.button} variant='secondary'> Novo Usuário </Button>} position="right center">
        <CreateUsers />
      </Popup>
      <Popup trigger={<Button className={style.button} variant='secondary'> Agendar Consulta </Button>} position="right center">
        <AgendarConsulta />
      </Popup>
      <Popup trigger={<Button className={style.button} variant='secondary'> Cadastrar Paciente </Button>} position="right center">
        <CadastrarPaciente />
      </Popup>
      <Button className={style.button} variant='secondary' onClick={() => handleFormChange(FormType.Medico)}>Buscar Médico</Button>
      <Button className={style.button} variant='secondary'  onClick={() => handleFormChange(FormType.Paciente)}>Buscar Paciente</Button>
      {searchBarVisible && renderForm()}
      
    </div>
  );
};