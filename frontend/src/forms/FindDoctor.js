import React, { useState } from 'react';
import axios from 'axios';

const ProcuraMedico = () => {
  const [searchValue, setSearchValue] = useState('');
  const [medico, setMedico] = useState(null);
  const [errorMessage, setErrorMessage] = useState('');

  const handleSearch = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.get(`http://localhost:8080/medico?nome=${searchValue}&crm=${searchValue}`);

      if (response.data.length === 0) {
        setMedico(null);
        setErrorMessage('Médico não cadastrado!');
      } else {
        setMedico(response.data[0]);
        setErrorMessage('');
      }
    } catch (error) {
      console.error(error);
    }
  };

  const handleSearchChange = (e) => {
    setSearchValue(e.target.value);
  };

  return (
    <div>
      <form onSubmit={handleSearch}>
        <label>
          Nome ou CRM:
          <input
            type="text"
            value={searchValue}
            onChange={handleSearchChange}
          />
        </label>
        <button type="submit">Buscar</button>
      </form>

      {errorMessage && <p>{errorMessage}</p>}

      {medico && (
        <div>
          <h2>Detalhes do médico:</h2>
          <p>Nome: {medico.nome}</p>
          <p>CRM: {medico.crm}</p>
          <p>Especialidade: {medico.especialidade}</p>
          <p>Telefone: {medico.telefone}</p>
        </div>
      )}
    </div>
  );
};

export default ProcuraMedico;
