import React, { useState } from 'react';
import axios from 'axios';

const CreateDoctorForm = () => {
  const [name, setName] = useState('');
  const [username, setUsername] = useState('');
  const [crm, setCrm] = useState('');
  const [telefone, setTelefone] = useState('');
  const [especialidade, setEspecialidade] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    const newMedico = {
      nome: name,
      username: username,
      crm: crm,
      telefone: telefone,
      especialidade: especialidade,
      created_at: new Date().toISOString(),
      roles: [{ authority: 'ROLE_MEDICO' }],
      consultas: []
    };

    try {
      const response = await axios.post('http://localhost:8080/medicos', newMedico);
      console.log(response.data);
      setName('');
      setUsername('');
      setCrm('');
      setTelefone('');
      setEspecialidade('');
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Nome:
        <input
          type="text"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
      </label>

      <label>
        Username:
        <input
          type="text"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
      </label>

      <label>
        CRM:
        <input
          type="text"
          value={crm}
          onChange={(e) => setCrm(e.target.value)}
        />
      </label>

      <label>
        Telefone:
        <input
          type="number"
          value={telefone}
          onChange={(e) => setTelefone(e.target.value)}
        />
      </label>

      <label>
        Especialidade:
        <input
          type="text"
          value={especialidade}
          onChange={(e) => setEspecialidade(e.target.value)}
        />
      </label>

      <button type="submit">Submit</button>
    </form>
  );
};

export default CreateDoctorForm;
