import React, { useState, useEffect } from 'react';
import axios from 'axios';

const ProcuraPaciente = () => {
  const [searchValue, setSearchValue] = useState('');
  const [paciente, setPaciente] = useState(null);
  const [errorMessage, setErrorMessage] = useState('');
  const headers = {
    username: 'admin',
    password: '123',
    'Access-Control-Allow-Origin': '*'
  };

  useEffect(() => {
    const searchPaciente = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/paciente?nome=${searchValue}&cpf=${searchValue}`, headers);

        if (response.data.length === 0) {
          setPaciente(null);
          setErrorMessage('Paciente não cadastrado');
        } else {
          setPaciente(response.data[0]);
          setErrorMessage('Paciente não encontrado!');
        }
      } catch (error) {
        console.error(error);
      }
    };
    searchPaciente();
  }, [searchValue]);

  const handleSearchChange = (e) => {
    setSearchValue(e.target.value);
  };

  return (
    <div>
      <form>
        <label>
          Nome ou CPF:
          <input
            type="text"
            value={searchValue}
            onChange={handleSearchChange}
          />
        </label>
      </form>

      {errorMessage && <p>{errorMessage}</p>}

      {paciente && (
        <div>
          <h2>Detalhes do Paciente</h2>
          <p>Nome: {paciente.nome}</p>
          <p>CPF: {paciente.cpf}</p>
          <p>Endereço: {paciente.endereco}</p>
          <p>Telefone: {paciente.telefone}</p>
          <p>Email: {paciente.email}</p>
        </div>
      )}
    </div>
  );
};

export default ProcuraPaciente;
