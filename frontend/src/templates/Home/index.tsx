import style from './style.module.scss';
import { Button } from 'react-bootstrap';
import React, { useState } from 'react';
import FindDoctor from '../../../forms/FindDoctor';
import CreateDoctor from '../forms/CreateDoctor';
import CreateUsers from '../../../forms/CreateUsers';
import FindPatient from '../../../forms/FindPatient';

export const SidebarOptions = () => {

    enum FormType {
        Medico = 'newmedico',
        Paciente = 'newpaciente',
        findMedico = 'achamedico',
        findPaciente = 'achapaciente'
      }
    

  const HomePage: React.FC = () => {
    const [activeForm, setActiveForm] = useState<FormType | null>(null);

                
            const handleFormChange = (formType: FormType) => {
                setActiveForm(formType);
                        }
            
      };
      
      const renderForm = () => {
        switch (activeForm) {
          case FormType.Medico:
            return <FindDoctor/>;
          case FormType.Paciente:
            return <FindPatient/>;
          default:
            return null;
                };
            }

  



  return (
    <div className={style.sidebarOptions}>
      <Button className={style.button} variant='secondary'>
        Agendar consulta
      </Button>
      <Button className={style.button} variant='secondary'>
        Buscar paciente
      </Button>
      <Button className={style.button} variant='secondary'>
        Buscar médico
      </Button>
      <Button className={style.button} variant='secondary'>
        Fila de espera
      </Button>

      <button onClick={() => handleFormChange(FormType.Paciente)}>Paciente Search</button>

      {renderForm()}
    </div>
  );
};